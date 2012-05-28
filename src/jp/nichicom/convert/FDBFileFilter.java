package jp.nichicom.convert;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FDBFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String ext = getExtension(f);
        if (ext != null) {
            if (ext.equals("fdb")) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public String getDescription() {
        return "�f�[�^�x�[�X�t�@�C��(.fdb)";
    }

    private String getExtension(File f) {
        String ext = null;
        String filename = f.getName();
        int dotIndex = filename.lastIndexOf('.');

        if ((dotIndex > 0) && (dotIndex < filename.length() - 1)) {
            ext = filename.substring(dotIndex + 1).toLowerCase();
        }

        return ext;
    }
}
