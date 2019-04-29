package com.propensi.winscore.controller;

import com.propensi.winscore.model.UserModel;
import com.propensi.winscore.rest.BaseResponses;
import com.propensi.winscore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:8081")
@RequestMapping("/pembeli")
public class PembeliController {

    @Autowired
    private UserService userService;


    /*@GetMapping(value="/list-admin")
    public BaseResponses<List<SerializerAdminUser>> retrieveAllAdmin() {
        BaseResponses<List<SerializerAdminUser>> response = new BaseResponses<List<SerializerAdminUser>>();
        List<SerializerAdminUser> serializerAdminUsers = new ArrayList<SerializerAdminUser>();
        List<AdminModel> listAdmin = adminService.findAll();*//*



        for (AdminModel i: listAdmin) {
            serializerAdminUsers.add(new SerializerAdminUser(i.getId_admin(), i));
        }

        if(listAdmin != null) {
            response.setResult(serializerAdminUsers);
            response.setMessage("Success");
            response.setStatus(200);
        } else {
            response.setStatus(404);
            response.setMessage("Not Found");
        }
        return response;
    }*/

    @CrossOrigin
    @GetMapping(value="/detail-pembeli/{id_user}")
    public BaseResponses<UserModel> retrieveDetailPembeli(@PathVariable(value="id_user") long id_user) {
        System.out.println("masuk");
        BaseResponses<UserModel> response = new BaseResponses<UserModel>();
        UserModel userModel = userService.getUserById(id_user);
        if(userModel != null) {
            response.setResult(userModel);
            response.setMessage("Success");
            response.setStatus(200);
        } else {
            response.setStatus(404);
            response.setMessage("Not Found");
        }
        return response;
    }

    @PostMapping("/post")
    public BaseResponses<UserModel> addPembeli(@RequestBody Map<String, Object> getAdmin) throws ParseException {
        BaseResponses<UserModel> response = new BaseResponses<>();
        System.out.println("aaaa");
        UserModel userModel = new UserModel();
        System.out.println((String) getAdmin.get("role"));

        userModel.setNama((String) getAdmin.get("nama"));
        userModel.setPassword((String) getAdmin.get("password"));
        userModel.setAlamat((String) getAdmin.get("alamat"));
        userModel.setEmail((String) getAdmin.get("email"));
        userModel.setNo_telp((String) getAdmin.get("no_telp"));
        userModel.setRole((String) getAdmin.get("role"));

        userService.addUser(userModel);

        response.setStatus(200);
        response.setMessage("Success");
        response.setResult(userModel);
        //produkService.addNewProduk(produk);
        return response;
    }

    @CrossOrigin
    @PostMapping(value="/detail-pembeli/ubah-detail-pembeli/{id_user}")
    public BaseResponses<UserModel> updatePembeli(@RequestBody UserModel updatepembeli,
                                                 @PathVariable(value="id_user") long id_user) throws ParseException {
        BaseResponses<UserModel> response = new BaseResponses<UserModel>();
        UserModel user = userService.getUserById(id_user);
        user.setNo_telp(updatepembeli.getNo_telp());
        user.setAlamat(updatepembeli.getAlamat());
        user.setEmail(updatepembeli.getEmail());
        user.setNama(updatepembeli.getNama());
        user.setPassword(updatepembeli.getPassword());
        userService.addUser(user);


        response.setStatus(200);
        response.setMessage("Success");
        response.setResult(updatepembeli);
        //produkService.addNewProduk(produk);
        return response;
    }

    @PostMapping(value="/delete/{id_user}")
    public BaseResponses deletePembeli(@PathVariable long id_user) {
        BaseResponses<UserModel> response = new BaseResponses<UserModel>();
        UserModel user = userService.getUserById(id_user);
        userService.deleteUser(user);
        response.setStatus(200);
        response.setMessage("Success");
        return response;
    }
}
