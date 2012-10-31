
/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKANCHO（JMA care benefit management software）
 * Copyright(C) 2002 JMA (Japan Medical Association)
 *
 * This program is part of "QKANCHO (JMA care benefit management software)".
 *
 * This program is distributed in the hope that it will be useful
 * for further advancement in medical care, according to JMA Open
 * Source License, but WITHOUT ANY WARRANTY.
 * Everyone is granted permission to use, copy, modify and
 * redistribute this program, but only under the conditions described
 * in the JMA Open Source License. You should have received a copy of
 * this license along with this program. If not, stop using this
 * program and contact JMA, 2-28-16 Honkomagome, Bunkyo-ku, Tokyo,
 * 113-8621, Japan.
 *****************************************************************
 * アプリ: QKANCHO
 * 開発者: 田中　統蔵
 * 作成日: 2006/09/13  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム nichicom (N)
 * サブシステム ユーティリティ (U)
 * プロセス PDF比較 (001)
 * プログラム PDF比較 (NU001)
 *
 *****************************************************************
 */
package jp.nichicom.ndk.affair.nu.nu001;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.filechooser.ACFileChooser;
import jp.nichicom.ac.filechooser.ACFileFilter;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

import com.itextpdf.text.pdf.PdfReader;
/**
 * PDF比較(NU001) 
 */
@SuppressWarnings("serial")
public class NU001 extends NU001Event {
  /**
   * コンストラクタです。
   */
  public NU001(){
  }

  //コンポーネントイベント

  public void initAffair(ACAffairInfo affair) throws Exception {
      super.initAffair(affair);
      setTitle("PDF比較ツール");
  }
  /**
   * 「比較」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void compareActionPerformed(ActionEvent e) throws Exception{
    // 比較
      
      if(!new File(getPdf1().getText()).exists()){
         ACMessageBox.showExclamation("PDF1が見つかりません。"); 
         return;
      }
      if(!new File(getPdf2().getText()).exists()){
          ACMessageBox.showExclamation("PDF2が見つかりません。"); 
          return;
       }
      
      final PdfReader p1 = new PdfReader(getPdf1().getText());
      final PdfReader p2 = new PdfReader(getPdf2().getText());
      final int pages1=p1.getNumberOfPages();
      final int pages2=p2.getNumberOfPages();
      
      if(pages1!=pages2){
          if(pages1>pages2){
              ACMessageBox.showExclamation("PDF1よりもPDF2のページ数が少ないです。"); 
              return;
          }
          if (ACMessageBox.showOkCancel("PDFのページ数が異なります。"
                    + ACConstants.LINE_SEPARATOR
                    + "PDF1のすべてのページがPDF2に含まれるかで比較しますか？")!=
                        ACMessageBox.RESULT_OK) {
              return;
          }
      }
      
      new Runnable() {
          private boolean firstLock;

            public void run() {
                final int stopKeyCode = KeyEvent.VK_CAPS_LOCK;
                firstLock = Toolkit.getDefaultToolkit().getLockingKeyState(stopKeyCode);
                
                LinkedList<Integer> pages =new LinkedList<Integer>();
                for(int i=1; i<=pages2; i++){
                    pages.add(new Integer(i));
                }
                
                errorCount = 0;
                pageOfProcessed = 0;
                pageOfCount = pages1;
                StringBuilder sb = new StringBuilder();

                for (int i = 1; i <= pages1; i++) {
                    try {
                        boolean match = false;
                        byte[] b1 = p1.getPageContent(i);
                        Iterator<Integer> it = pages.iterator();
                        while(it.hasNext()){
                            int page = ((Integer)it.next()).intValue();
                            byte[] b2 = p2.getPageContent(page);
                            if (Arrays.equals(b1, b2)) {
                                sb.append("○PDF1(" + i + ") = PDF2("
                                        + page + ")"
                                        + ACConstants.LINE_SEPARATOR);
                                match = true;
                                it.remove();
                                break;
                            }
                        }
                        if (!match) {
                            sb.append("×PDF1(" + i + ") 【一致なし】"
                                    + ACConstants.LINE_SEPARATOR);
                            errorCount++;
                        }
                    } catch (Exception ex) {
                        sb.append("※PDF1(" + i + ") 【処理例外】"
                                + ACConstants.LINE_SEPARATOR);
                        errorCount++;
                    }

                    setProgress(sb);
                    pageOfProcessed = i;
                    
                    
                    if (Toolkit.getDefaultToolkit().getLockingKeyState(stopKeyCode)!=firstLock) {
                        getResult().setText(
                        "！比較中断(" + pageOfProcessed + " / " + pageOfCount
                                + ") / 不一致数:" + errorCount + " 件"
                                + ACConstants.LINE_SEPARATOR + sb.toString());
                        return;
                    }
                    
                }

                getResult().setText(
                        "■比較完了(" + pageOfProcessed + " / " + pageOfCount
                                + ") / 不一致数:" + errorCount + " 件"
                                + ACConstants.LINE_SEPARATOR + sb.toString());

            }

        }.run();
      
      

  }
  private int errorCount;
  private int pageOfCount;
  private int pageOfProcessed;
  private void setProgress(StringBuilder sb){
      getResult().setText(
                "□比較中(" + pageOfProcessed + " / " + pageOfCount + ") / 不一致数:"
                        + errorCount + " 件 ※CAPS-LOCKで中断" + ACConstants.LINE_SEPARATOR
                        + sb.toString());
      repaint();
      getThis().paintImmediately(getThis().getVisibleRect());

  }

  /**
   * 「終了」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void exitActionPerformed(ActionEvent e) throws Exception{
    // 終了
      if(ACMessageBox.showOkCancel("終了しますか？")!=ACMessageBox.RESULT_OK){
          return;
      }
      System.exit(0);
  }

  /**
   * 「PDF1参照」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void pdf1BrowseActionPerformed(ActionEvent e) throws Exception{
    // PDF1参照
      ACFileFilter filter=new ACFileFilter();
      filter.setDescription("PDFファイル(*.pdf)");
      filter.setFileExtensions(new String[]{"pdf"});
      File f=new ACFileChooser().showOpenDialog(getPdf1().getText(), getPdf1()
                .getText(), "PDF1を選択", filter);
      if(f==null){
          return;
      }
      getPdf1().setText(f.getAbsolutePath());
  }

  /**
   * 「PDF2参照」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void pdf2BrowseActionPerformed(ActionEvent e) throws Exception{
    // PDF2参照
      ACFileFilter filter=new ACFileFilter();
      filter.setDescription("PDFファイル(*.pdf)");
      filter.setFileExtensions(new String[]{"pdf"});
      File f=new ACFileChooser().showOpenDialog(getPdf2().getText(), getPdf2()
                .getText(), "PDF2を選択", filter);
      if(f==null){
          return;
      }
      getPdf2().setText(f.getAbsolutePath());
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(NU001.class.getName(), param));
  }

}
