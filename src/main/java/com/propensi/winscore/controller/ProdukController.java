package com.propensi.winscore.controller;

import com.propensi.winscore.model.GaransiModel;
import com.propensi.winscore.model.ProdukModel;
import com.propensi.winscore.rest.BaseResponse;
import com.propensi.winscore.service.FileStorageService;
import com.propensi.winscore.service.GaransiServiceImpl;
import com.propensi.winscore.service.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.sql.Date;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/api")
//@PreAuthorize("isAuthenticated()")
public class ProdukController {

    @Autowired
    private ProdukService produkService;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private GaransiServiceImpl garansiService;

    
    public void setProdukService(ProdukService produkService) {
        this.produkService = produkService;
    }

    @CrossOrigin
    @GetMapping(value = "/list-produk/{kategori}")
    private Object viewAllProduk(@PathVariable("kategori") String kategori){
        System.out.println(kategori);
        BaseResponse<List<ProdukModel>> response = new BaseResponse<List<ProdukModel>>();
        List<ProdukModel> listProduk = produkService.getProdukByKategori(kategori);
        System.out.println(listProduk);
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(listProduk);
        System.out.println("Masuk ke produk sort");
        return response;
    }

    @GetMapping(value="/list-produk")
    public BaseResponse<List<ProdukModel>> retrieveAllProduk() {
        BaseResponse<List<ProdukModel>> response = new BaseResponse<List<ProdukModel>>();
        List<ProdukModel> listProduk = produkService.findAll();
        if(listProduk != null) {
            response.setResult(listProduk);
            response.setMessage("Success");
            response.setStatus(200);
        } else {
            response.setStatus(404);
            response.setMessage("Not Found");
        }
        return response;
    }

    @GetMapping(value="/list-produk/detail-produk/{id_produk}")
    public BaseResponse<ProdukModel> retrieveDetailProduk(@PathVariable(value="id_produk") long id_produk) {
        BaseResponse<ProdukModel> response = new BaseResponse<ProdukModel>();
        ProdukModel detailProduk = produkService.getProdukById(id_produk);
        if(detailProduk != null) {
            response.setResult(detailProduk);
            response.setMessage("Success");
            response.setStatus(200);
        } else {
            response.setStatus(404);
            response.setMessage("Not Found");
        }
        return response;
    }

    @CrossOrigin
    @PostMapping("/list-produk/tambah-produk")
    public BaseResponse<ProdukModel> addProduk(@RequestParam(value = "nama", required = true) String nama,
                                                @RequestParam(value = "kategori_produk", required = true) String kategoriProduk,
                                                @RequestParam(value = "kode_produk", required = true) String kodeProduk,
                                                @RequestParam(value = "detail_produk", required = true) String detailProduk,
                                                @RequestParam(value = "status", required = true) String status,
                                                @RequestParam(value = "harga", required = true) Long harga,
                                                @RequestParam(value = "tgl_garansi", required = true) String tglGaransi,
                                                @RequestParam(value = "foto_produk", required = true) MultipartFile fotoProduk) throws ParseException {
        BaseResponse<ProdukModel> response = new BaseResponse<>();
        ProdukModel produk = new ProdukModel();
        GaransiModel garansi = new GaransiModel();
        produk.setNama(nama);
        produk.setKode_produk(kodeProduk);
        produk.setDetail_produk(detailProduk);
        produk.setStatus(status);
        produk.setHarga(harga);
        produk.setKategori_produk(kategoriProduk);
        String fileName = fileStorageService.storeFile(fotoProduk);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/productPicture/")
                .path(fileName)
                .toUriString();

        produk.setFoto_produk(fileDownloadUri);
        System.out.println(produk.getId_produk());
        //System.out.println(produk.toString());
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(tglGaransi);
        Date tglKadaluarsa = new Date(date.getTime());
        garansi.setTgl_kadaluarsa(tglKadaluarsa);
        garansiService.addNewGaransi(garansi);
        produk.setId_garansi(garansi);
        ProdukModel newProduk = produkService.addNewProduk(produk);

        response.setStatus(200);
        response.setMessage("Success");
        response.setResult(newProduk);
        //produkService.addNewProduk(produk);
        return response;
    }

    @CrossOrigin
    @PostMapping(value="/list-produk/detail-produk/{id_produk}/ubah-detail-produk")
    public BaseResponse<ProdukModel> updateProduk(@RequestBody ProdukModel updateproduk,
                                                    @PathVariable(value="id_produk") long id_produk) throws ParseException {
        BaseResponse<ProdukModel> response = new BaseResponse<ProdukModel>();
        ProdukModel produk = produkService.getProdukById(id_produk);
        System.out.println(updateproduk.getId_garansi().getTgl_kadaluarsa());
        produk.setNama(updateproduk.getNama());
        produk.setHarga(updateproduk.getHarga());
        produk.setStatus(updateproduk.getStatus());
        produk.setDetail_produk(updateproduk.getDetail_produk());
        produk.setKode_produk(updateproduk.getKode_produk());
        GaransiModel garansi = produk.getId_garansi();
        garansi.setTgl_kadaluarsa(updateproduk.getId_garansi().getTgl_kadaluarsa());
//        produk.setNama((String) updateproduk.get("nama"));
//        produk.setKode_produk((String) updateproduk.get("kode_produk"));
//        produk.setDetail_produk((String) updateproduk.get("detail_produk"));
//        produk.setStatus((String) updateproduk.get("status"));
//        GaransiModel garansi = produk.getId_garansi();
//        GaransiModel getGaransi = (GaransiModel) updateproduk.get("id_garansi");
//        garansi.setTgl_kadaluarsa(getGaransi.getTgl_kadaluarsa());
//        garansiService.addNewGaransi(garansi);
////        produk.setHarga((long) updateproduk.get("harga"));
////        produk.setId_garansi((GaransiModel) updateproduk.get("id_garansi"));
//        System.out.println(produk.getId_produk());

        ProdukModel ubahDetailProduk = produkService.updateProduk(produk);

        response.setStatus(200);
        response.setMessage("Success");
        response.setResult(ubahDetailProduk);
        //produkService.addNewProduk(produk);
        return response;
    }

    @PostMapping(value="/list-produk/{id_produk}")
    public BaseResponse deleteProduk(@PathVariable Long id_produk) {
        BaseResponse<ProdukModel> response = new BaseResponse<ProdukModel>();
        ProdukModel produk = produkService.getProdukById(id_produk);
        produkService.deleteProduk(produk);
        response.setStatus(200);
        response.setMessage("Success");
        return response;
    }

}


