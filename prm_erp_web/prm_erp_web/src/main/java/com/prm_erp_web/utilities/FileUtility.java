/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prm_erp_web.utilities;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import prm_erp.utility.Constants;

/**
 *
 * @author PDP_Shiva
 */
@Component
public class FileUtility {

    @Autowired
    private HttpServletRequest request;

    public void saveProfilePic(MultipartFile file, String fileName) throws IOException {
        String realPath = request.getServletContext().getRealPath("/files/Images/");
        File file1 = new File(realPath);
        if (!file1.exists()) {
            file1.mkdir();
        }
        file.transferTo(new File(file1.getPath() + "/" + fileName));
    }
}
