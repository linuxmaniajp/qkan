package jp.nichicom.update.task;

import java.util.ArrayList;
import java.util.Iterator;


import jp.nichicom.update.MainFrame;

public class TaskProcesser implements Runnable {
    private boolean update=false;
    private Exception runException; 
    private ArrayList<AbstractTask> taskArray;
    private MainFrame frame;
    private String title="";
    private int progressValue=0;
    
    /**
     * progressValue を返します。
     * @return progressValue
     */
    public int getProgressValue() {
        return progressValue;
    }
    public String getTitle() {
        return title;
    }

    public TaskProcesser(ArrayList<AbstractTask> taskArray, MainFrame frame){
        this.taskArray = taskArray;
        this.frame = frame;
        
        int count = 0;
        Iterator<AbstractTask> it=taskArray.iterator();
        while(it.hasNext()){
            count += ((AbstractTask) it.next()).size();
        }
        frame.progress.setMaximum(count);
    }
    
    @Override
    public void run(){
        runException = null;
        try {
            for (int i = 0; i < taskArray.size(); i++) {
                AbstractTask task = (AbstractTask) taskArray.get(i);
                if (task.runTask(this)) {
                    update = true;
                }
            }
        } catch (Exception ex) {
            runException = ex;
        }
        
        frame.taskEnd(this);
    }
    /**
     * 進捗を更新します。
     * @param title
     */
    public void setStatus(String title) {
        frame.status.setText(title);
    }
    public void addProgress(){
        progressValue++;
        frame.progress.setValue(progressValue);
    }
    public void skipTask(AbstractTask task){
        progressValue += task.size();
        frame.progress.setValue(progressValue);
    }
    
    /**
     * runException を返します。
     * @return runException
     */
    public Exception getRunException() {
        return runException;
    }
    /**
     * update を返します。
     * @return update
     */
    public boolean isUpdate() {
        return update;
    }
}
