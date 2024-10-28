package com.karyawanedi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.karyawanedi.entity.Karyawan;
import com.karyawanedi.service.KaryawanService;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private KaryawanService karyawanService;

    @GetMapping
    public String welcome(Model model) {
        // bisa melakukan sesuatu untuk return ke halaman index
        String messages = "Daftar Pelamar PT EDI";
        model.addAttribute("msg", messages);
        model.addAttribute("karyawanEdi", karyawanService.findAll());
        return "index";
    }

    @GetMapping("/add_karyawan")
    public String add(Model model) {
        model.addAttribute("karyawan", new Karyawan());
        return "add_karyawan";
    }

    @PostMapping("/save_karyawan")
    public String save(Karyawan karyawan, Model model) {
        karyawanService.addKaryawan(karyawan);
        return "redirect:/";
    }

    @GetMapping("/delete/{nik}")
    public String delete(@PathVariable("nik") Long nik) {
        // panggil service untuk hapus data
        karyawanService.deleteById(nik);
        return "redirect:/";
    }

    @GetMapping("/edit/{nik}")
    public String edit(@PathVariable("nik") Long nik, Model model) {
        // panggil service untuk edit data berdasarkan nik
        model.addAttribute("karyawan", karyawanService.findById(nik));
        return "edit_karyawan";
    }

    @PostMapping("/update_karyawan")
    public String update(Karyawan karyawan, Model model) {
        // call service update
        karyawanService.updateKaryawan(karyawan);
        return "redirect:/";
    }

    @GetMapping("/detail/{nik}")
    public String detail(@PathVariable("nik") Long nik, Model model) {
        Karyawan karyawan = karyawanService.findById(nik).orElse(null);

        // panggil service untuk edit data berdasarkan nik
        String messages = "Informasi Pelamar";
        model.addAttribute("msg_info", messages);
        model.addAttribute("karyawan", karyawan);
        return "detail_karyawan";
    }
}
