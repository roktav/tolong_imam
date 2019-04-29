package com.propensi.winscore.controller;

import com.propensi.winscore.model.AdminModel;
import com.propensi.winscore.model.UserModel;
import com.propensi.winscore.rest.BaseResponses;
import com.propensi.winscore.rest.SerializerAdminUser;
import com.propensi.winscore.service.AdminService;
import com.propensi.winscore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:8081")
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;


    @GetMapping(value="/list-admin")
    public BaseResponses<List<SerializerAdminUser>> retrieveAllAdmin() {
        BaseResponses<List<SerializerAdminUser>> response = new BaseResponses<List<SerializerAdminUser>>();
        List<SerializerAdminUser> serializerAdminUsers = new ArrayList<SerializerAdminUser>();
        List<AdminModel> listAdmin = adminService.findAll();



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
    }

    /*@GetMapping(value="/list-admin/detail-admin/{id_admin}")
    public BaseResponses<AdminModel> retrieveDetailAdmin(@PathVariable(value="id_admin") long id_admin) {
        System.out.println("masuk");
        BaseResponses<AdminModel> response = new BaseResponses<AdminModel>();
        UserModel userModel = userService.getUserById(id_admin).get();
        AdminModel detailAdmin = adminService.getAdminbyId(id_admin);
        if(detailAdmin != null) {
            response.setResult(detailAdmin);
            response.setMessage("Success");
            response.setStatus(200);
        } else {
            response.setStatus(404);
            response.setMessage("Not Found");
        }
        return response;
    }*/

    @PostMapping("/post")
    public BaseResponses<AdminModel> addAdmin(@RequestBody Map<String, Object> getAdmin) throws ParseException {
        BaseResponses<AdminModel> response = new BaseResponses<>();
        UserModel userModel = new UserModel();
        AdminModel adminModel = new AdminModel();
        System.out.println((String) getAdmin.get("role"));

        userModel.setNama((String) getAdmin.get("nama"));
        userModel.setPassword((String) getAdmin.get("password"));
        userModel.setAlamat((String) getAdmin.get("alamat"));
        userModel.setEmail((String) getAdmin.get("email"));
        userModel.setNo_telp((String) getAdmin.get("no_telp"));
        userModel.setRole((String) getAdmin.get("role"));

        adminModel.setId_pegawai((String) getAdmin.get("id_pegawai"));
        adminModel.setJabatan((String) getAdmin.get("jabatan"));
        adminModel.setId_admin(userModel);
        adminModel.setUsername((String) getAdmin.get("username"));
        adminModel.setStatus((String) getAdmin.get("status"));
        adminModel.setKantor_cabang((String) getAdmin.get("cabang"));

        userService.addUser(userModel);
        adminService.addNewAdmin(adminModel);

        response.setStatus(200);
        response.setMessage("Success");
        response.setResult(adminModel);
        //produkService.addNewProduk(produk);
        return response;
    }

    @CrossOrigin
    @PostMapping(value="/list-admin/detail-admin/{id_admin}/ubah-detail-admin")
    public BaseResponses<AdminModel> updateAdmin(@RequestBody AdminModel updateadmin,
                                                   @PathVariable(value="username") String username) throws ParseException {
        BaseResponses<AdminModel> response = new BaseResponses<AdminModel>();
        AdminModel admin = adminService.getAdminbyUsername(username);
        admin.setStatus(updateadmin.getStatus());
        admin.setJabatan(updateadmin.getJabatan());
        admin.setKantor_cabang(updateadmin.getKantor_cabang());

        response.setStatus(200);
        response.setMessage("Success");
        response.setResult(updateadmin);
        //produkService.addNewProduk(produk);
        return response;
    }

    @PostMapping(value="/list-admin/{id_admin}")
    public BaseResponses deleteAdmin(@PathVariable String username) {
        BaseResponses<AdminModel> response = new BaseResponses<AdminModel>();
        AdminModel adminModel = adminService.getAdminbyUsername(username);
        adminService.deleteAdmin(adminModel);
        response.setStatus(200);
        response.setMessage("Success");
        return response;
    }
}
