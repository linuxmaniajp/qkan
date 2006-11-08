package jp.or.med.orca.qkan.affair;

import jp.nichicom.ac.core.ACClassLoader;

public class QkanStarter {
    public static void main(String[] args) {
        try {
            ACClassLoader.executeMain(
                    "jp.or.med.orca.qkan.affair.qm.qm001.QM001",
                    ACClassLoader.toURL(new String[] {
                            "lib/firebirdsql-full.jar", "lib/iText.jar",
                            "lib/iTextAsian.jar", "lib/vr-impl.jar",
                            "lib/bridge.jar","lib/ac-lib-impl.jar" }), new String[] { "jp" },
                            args);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

}