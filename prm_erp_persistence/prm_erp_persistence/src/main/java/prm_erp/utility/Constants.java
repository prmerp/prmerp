/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prm_erp.utility;

/**
 *
 * @author PDP_Shiva
 */
public final class Constants {

    public static String DEFAULT_FILE_CHOOSER_DIRECTORY = System.getProperty("user.home");
    public static String PROFILE_PIC_DIR = "/files/Images/";
    public static String PROFILE_PIC = "profile-pics";

    public final static class FileDialog {

        public static String DEFAULT_TITLE = "Open File Chooser";

    }

    public final static class Commons {

        public static long DEFAULT_EXPIRYTIME = 5000 * 60;
    }

    public final static class Modules {

        public static int PERSON = 1;

    }

    public final static String getUniqueLogoName(String fName, int module) {
        return new StringBuilder(PROFILE_PIC).append("_").append(module).append("_").append(fName).append("_").append(System.currentTimeMillis()).toString();
    }
}
