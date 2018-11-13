package prm_erp.utility;

/**
 *
 * @author PDP_Shiva
 */
public class UserSession {

    /**
     * @return the userId
     */
    public static Long getUserId() {
        return userId;
    }

    /**
     * @param aUserId the userId to set
     */
    public static void setUserId(Long aUserId) {
        userId = aUserId;
    }

    /**
     * @return the userName
     */
    public static String getUserName() {
        return userName;
    }

    /**
     * @param aUserName the userName to set
     */
    public static void setUserName(String aUserName) {
        userName = aUserName;
    }

    private static Long userId;
    private static String userName;

}
