package jp.nichicom.ac.lib.care.claim.print.schedule;

import java.util.ArrayList;
import java.util.List;

import jp.nichicom.vr.util.VRMap;

/**
 * 構築パラメタです。
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
     * 印刷パラメタ を返します。
     * 
     * @return 印刷パラメタ
     */
    public VRMap getPrintParameter() {
        return printParameter;
    }

    /**
     * 印刷パラメタ を設定します。
     * 
     * @param printParameter 印刷パラメタ
     */
    public void setPrintParameter(VRMap printParameter) {
        this.printParameter = printParameter;
    }

    /**
     * 全ページ非表示にするID集合 を返します。
     * 
     * @return 全ページ非表示にするID集合
     */
    public List getInvisibles() {
        return invisibles;
    }

    /**
     * 全ページ非表示にするID集合 を設定します。
     * 
     * @param invisibles 全ページ非表示にするID集合
     */
    public void setInvisibles(List invisibles) {
        this.invisibles = invisibles;
    }

    /**
     * 次の書き出し位置 を返します。
     * 
     * @return 次の書き出し位置
     */
    public int getCurrentRow() {
        return currentRow;
    }

    /**
     * 次の書き出し位置 を設定します。
     * 
     * @param beginRow 次の書き出し位置
     */
    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    /**
     * 雛形ページ を返します。
     * 
     * @return 雛形ページ
     */
    public VRMap getFormPage() {
        return formPage;
    }

    /**
     * 雛形ページ を設定します。
     * 
     * @param formPage 雛形ページ
     */
    public void setFormPage(VRMap formPage) {
        this.formPage = formPage;
    }

    /**
     * 完成ページ集合 を返します。
     * 
     * @return 完成ページ集合
     */
    public List getPages() {
        return pages;
    }

    /**
     * 完成ページ集合 を設定します。
     * 
     * @param pages 完成ページ集合
     */
    public void setPages(List pages) {
        this.pages = pages;
    }

    /**
     * 書き出し対象ページ を返します。
     * 
     * @return 書き出し対象ページ
     */
    public VRMap getTargetPage() {
        return targetPage;
    }

    /**
     * 書き出し対象ページ を設定します。
     * 
     * @param targetPage 書き出し対象ページ
     */
    public void setTargetPage(VRMap targetPage) {
        this.targetPage = targetPage;
    }
}
