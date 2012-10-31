package jp.nichicom.ac.lib.care.claim.print.schedule;

import java.util.ArrayList;
import java.util.List;

import jp.nichicom.vr.util.VRMap;

/**
 * �\�z�p�����^�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/05
 */
public class CareServicePrintParameter {
    private int currentRow;
    private VRMap formPage;
    private VRMap targetPage;
    private List pages;
    private List invisibles = new ArrayList();
    private VRMap printParameter;

    /**
     * ����p�����^ ��Ԃ��܂��B
     * 
     * @return ����p�����^
     */
    public VRMap getPrintParameter() {
        return printParameter;
    }

    /**
     * ����p�����^ ��ݒ肵�܂��B
     * 
     * @param printParameter ����p�����^
     */
    public void setPrintParameter(VRMap printParameter) {
        this.printParameter = printParameter;
    }

    /**
     * �S�y�[�W��\���ɂ���ID�W�� ��Ԃ��܂��B
     * 
     * @return �S�y�[�W��\���ɂ���ID�W��
     */
    public List getInvisibles() {
        return invisibles;
    }

    /**
     * �S�y�[�W��\���ɂ���ID�W�� ��ݒ肵�܂��B
     * 
     * @param invisibles �S�y�[�W��\���ɂ���ID�W��
     */
    public void setInvisibles(List invisibles) {
        this.invisibles = invisibles;
    }

    /**
     * ���̏����o���ʒu ��Ԃ��܂��B
     * 
     * @return ���̏����o���ʒu
     */
    public int getCurrentRow() {
        return currentRow;
    }

    /**
     * ���̏����o���ʒu ��ݒ肵�܂��B
     * 
     * @param beginRow ���̏����o���ʒu
     */
    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    /**
     * ���`�y�[�W ��Ԃ��܂��B
     * 
     * @return ���`�y�[�W
     */
    public VRMap getFormPage() {
        return formPage;
    }

    /**
     * ���`�y�[�W ��ݒ肵�܂��B
     * 
     * @param formPage ���`�y�[�W
     */
    public void setFormPage(VRMap formPage) {
        this.formPage = formPage;
    }

    /**
     * �����y�[�W�W�� ��Ԃ��܂��B
     * 
     * @return �����y�[�W�W��
     */
    public List getPages() {
        return pages;
    }

    /**
     * �����y�[�W�W�� ��ݒ肵�܂��B
     * 
     * @param pages �����y�[�W�W��
     */
    public void setPages(List pages) {
        this.pages = pages;
    }

    /**
     * �����o���Ώۃy�[�W ��Ԃ��܂��B
     * 
     * @return �����o���Ώۃy�[�W
     */
    public VRMap getTargetPage() {
        return targetPage;
    }

    /**
     * �����o���Ώۃy�[�W ��ݒ肵�܂��B
     * 
     * @param targetPage �����o���Ώۃy�[�W
     */
    public void setTargetPage(VRMap targetPage) {
        this.targetPage = targetPage;
    }
}
