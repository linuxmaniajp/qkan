package jp.or.med.orca.qkan.viewer;

import jp.nichicom.ac.core.ACClassLoader;

public class QkanCSVViewerStarter {
    public static void main(String[] args) {
        try {
            ACClassLoader.executeMain(
                    "jp.or.med.orca.qkan.viewer.qo.qo012.QO012",
                    ACClassLoader.toURL(new String[] {
                            "lib/firebirdsql-full.jar", "lib/iText.jar",
                            "lib/iTextAsian.jar", "lib/vr-impl.jar",
                            "lib/bridge.jar","lib/ac-lib-impl.jar","Qkan.jar" }), new String[] { "jp" });
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
