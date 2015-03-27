package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceCodeCalcurater;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindable;
import jp.nichicom.vr.component.AbstractVRCheckBox;
import jp.nichicom.vr.component.AbstractVRComboBox;
import jp.nichicom.vr.component.AbstractVRTextField;
import jp.nichicom.vr.component.VRRadioButtonGroup;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�l���p�̊��p�l���N���X�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class QS001ServicePanel extends ACPanel {
    private ACDBManager dbm;
    private boolean oldFacilityUser;
    private boolean planMode;
    private VRMap selectedProvider;
    private CareServiceCodeCalcurater calculater;

    /**
     * �P�ʐ��v�Z�N���X ��Ԃ��܂��B
     * 
     * @return �P�ʐ��v�Z�N���X
     */
    public CareServiceCodeCalcurater getCalculater() {
        return calculater;
    }

    /**
     * �P�ʐ��v�Z�N���X ��ݒ肵�܂��B
     * 
     * @param calculater �P�ʐ��v�Z�N���X
     */
    public void setCalculater(CareServiceCodeCalcurater calculater) {
        this.calculater = calculater;
    }

    /**
     * �\�胂�[�h�ł��邩 ��Ԃ��܂��B
     * 
     * @return �\�胂�[�h�ł��邩
     */
    public boolean isPlanMode() {
        return planMode;
    }

    /**
     * �\�胂�[�h�ł��邩 ��ݒ肵�܂��B
     * 
     * @param planMode �\�胂�[�h�ł��邩
     */
    public void setPlanMode(boolean planMode) {
        this.planMode = planMode;
    }

    /**
     * ���[�u�����҂ł��邩 ��Ԃ��܂��B
     * 
     * @return ���[�u�����҂ł��邩
     */
    public boolean isOldFacilityUser() {
        return oldFacilityUser;
    }

    /**
     * ���[�u�����҂ł��邩 ��ݒ肵�܂��B
     * 
     * @param oldFacilityUser ���[�u�����҂ł��邩
     */
    public void setOldFacilityUser(boolean oldFacilityUser) {
        this.oldFacilityUser = oldFacilityUser;
    }

    /**
     * Creates a new <code>JPanel</code> with a double buffer and a flow layout.
     */
    public QS001ServicePanel() {
        super();
    }

    /**
     * Creates a new <code>JPanel</code> with <code>FlowLayout</code> and the
     * specified buffering strategy. If <code>isDoubleBuffered</code> is true,
     * the <code>JPanel</code> will use a double buffer.
     * 
     * @param isDoubleBuffered a boolean, true for double-buffering, which uses
     *            additional memory space to achieve fast, flicker-free updates
     */
    public QS001ServicePanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    /**
     * Create a new buffered JPanel with the specified layout manager
     * 
     * @param layout the LayoutManager to use
     */
    public QS001ServicePanel(LayoutManager layout) {
        super(layout);
    }

    /**
     * Creates a new JPanel with the specified layout manager and buffering
     * strategy.
     * 
     * @param layout the LayoutManager to use
     * @param isDoubleBuffered a boolean, true for double-buffering, which uses
     *            additional memory space to achieve fast, flicker-free updates
     */
    public QS001ServicePanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    /**
     * DB�}�l�[�W����ݒ肵�܂��B
     * 
     * @param dbm DB�}�l�[�W��
     */
    public void setDBManager(ACDBManager dbm) {
        this.dbm = dbm;
    }

    /**
     * DB�}�l�[�W����Ԃ��܂��B
     * 
     * @return DB�}�l�[�W��
     */
    public ACDBManager getDBManager() {
        return dbm;
    }

    /**
     * �l���o�C���h�����ۂ̏����ł��B
     * 
     * @exception Exception ������O
     */
    public void binded() throws Exception {

    }

    /**
     * selectedProvider ��Ԃ��܂��B
     * 
     * @return selectedProvider
     */
    public VRMap getSelectedProvider() {
        return selectedProvider;
    }

    /**
     * selectedProvider ��ݒ肵�܂��B
     * 
     * @param selectedProvider selectedProvider
     */
    public void setSelectedProvider(VRMap selectedProvider) {
        this.selectedProvider = selectedProvider;
    }

    // [ID:0000666][Masahiko.Higuchi] 2012/12/13 edit begin �@�����敪�ɂ�镪��̏C��
    /**
     * ���̃T�[�r�X�p�l���������T�[�r�X�̖@�����敪(M_DETAIL.SYSTEM_BIND_PATH=14)��Ԃ��܂��B
     * 
     * @return �@�����敪
     * @exception Exception ������O
     * @see �p�����override���Ď������܂��B
     */
    public int getServiceLowVersion() throws Exception {
        return QkanConstants.SERVICE_LOW_VERSION_H2704;
    }

    // [ID:0000666][Masahiko.Higuchi] 2012/12/13 edit End

    // 2011/12-/13 Add Kamitsukasa
    private List<BindPathContainer> checkBindPaths;
    private List<BindPathPair> importBindPaths;
    private List<BindPathPair> restrictBindPaths;
    private VRMap importData;
    private Map<String, Component> cachedControls;

    public void putCheckProviderBindPath(String name, String providerBindPath) {
        if (checkBindPaths == null) {
            checkBindPaths = new ArrayList<BindPathContainer>();
        }
        checkBindPaths.add(new BindPathContainer(name, providerBindPath));
    }

    public void putImportProviderBindPath(String name, String providerBindPath,
            String serviceBindPath) {
        if (importBindPaths == null) {
            importBindPaths = new ArrayList<BindPathPair>();
        }
        importBindPaths.add(new BindPathPair(name, providerBindPath,
                serviceBindPath));
    }

    public void putRestrictProviderBindPath(String name,
            String providerBindPath, String serviceBindPath) {
        if (restrictBindPaths == null) {
            restrictBindPaths = new ArrayList<BindPathPair>();
        }
        restrictBindPaths.add(new BindPathPair(name, providerBindPath,
                serviceBindPath));
    }

    public VRMap getImportData() {
        return importData;
    }

    public boolean checkProvider(VRMap provider) throws Exception {

        // �]�L�f�[�^
        importData = new VRHashMap();

        if (checkBindPaths != null) {
            Iterator<BindPathContainer> it = checkBindPaths.iterator();
            BindPathContainer container;
            while (it.hasNext()) {
                container = it.next();
                if (!VRBindPathParser.has(container.getProviderBindPath(),
                        provider)) {
                    // log
                    System.out.println("CheckBindPath: Not found in provider: "
                            + container.getName() + " - "
                            + container.getProviderBindPath() + " ("
                            + VRBindPathParser.get("PROVIDER_ID", provider)
                            + " "
                            + VRBindPathParser.get("PROVIDER_NAME", provider)
                            + ")");

                    QkanMessageList.getInstance()
                            .QS001_ERROR_OF_NOT_USABLE_PROVIDER();
                    return false;
                }
            }
        }

        if (importBindPaths != null) {
            Iterator<BindPathPair> it = importBindPaths.iterator();
            Object value;
            BindPathPair pair;
            while (it.hasNext()) {
                pair = it.next();
                value = VRBindPathParser.get(pair.getProviderBindPath(),
                        provider);
                if (value != null) {
                    importData.setData(pair.getServiceBindPath(), value);
                } else {
                    // log
                    System.out
                            .println("ImportBindPath: Not found in provider: "
                                    + pair.getName()
                                    + " - "
                                    + pair.getProviderBindPath()
                                    + " - "
                                    + pair.getServiceBindPath()
                                    + " ("
                                    + VRBindPathParser.get("PROVIDER_ID",
                                            provider)
                                    + " "
                                    + VRBindPathParser.get("PROVIDER_NAME",
                                            provider) + ")");
                }
            }
        }

        setStateByRestrictBindPath(provider, false);

        return true;
    }

    protected void setStateByRestrictBindPath(VRMap provider,
            boolean onlyDisabled) throws Exception {

        if (restrictBindPaths != null) {
            if(provider == null) {
                return;
            }
            
            Iterator<BindPathPair> it = restrictBindPaths.iterator();
            Object value;
            BindPathPair pair;
            Component target;
            while (it.hasNext()) {
                pair = it.next();
                value = VRBindPathParser.get(pair.getProviderBindPath(),
                        provider);
                if (value != null && value instanceof Integer) {
                    target = getComponentFromBindPath(pair.getServiceBindPath());
                    if (target != null) {
                        // �e�����x���R���e�i�Ȃ瓯������
                        boolean isPair = false;
                        if (target.getParent() instanceof ACLabelContainer) {
                            isPair = true;
                        }
                        if (ACCastUtilities.toInt(value, 1) == 1) {
                            target.setEnabled(false);
                            if (isPair) {
                                target.getParent().setEnabled(false);
                            }
                        } else if (!onlyDisabled) {
                            target.setEnabled(true);
                            if (isPair) {
                                target.getParent().setEnabled(true);
                            }
                        }
                    } else {
                        // log
                        System.out
                                .println("RestrictBindPath: Component is not found: "
                                        + pair.getName()
                                        + " - "
                                        + pair.getProviderBindPath()
                                        + " - "
                                        + pair.getServiceBindPath()
                                        + " ("
                                        + VRBindPathParser.get("PROVIDER_ID",
                                                provider)
                                        + " "
                                        + VRBindPathParser.get("PROVIDER_NAME",
                                                provider) + ")");
                    }
                } else {
                    // log
                    System.out
                            .println("RestrictBindPath: Not found in provider: "
                                    + pair.getName()
                                    + " - "
                                    + pair.getProviderBindPath()
                                    + " - "
                                    + pair.getServiceBindPath()
                                    + " ("
                                    + VRBindPathParser.get("PROVIDER_ID",
                                            provider)
                                    + " "
                                    + VRBindPathParser.get("PROVIDER_NAME",
                                            provider) + ")");
                }
            }
        }

    }

    protected void resetStateByRestrictBindPath() throws Exception {
        setStateByRestrictBindPath(getSelectedProvider(), true);
    }

    public Component getComponentFromBindPath(String bindPath) {
        if (cachedControls == null) {
            cachedControls = new HashMap<String, Component>();
            cacheComponentBindPath(this);
        }

        return cachedControls.get(bindPath);
    }

    private void cacheComponentBindPath(Component target) {
        if ((target instanceof VRRadioButtonGroup)
                || (target instanceof AbstractVRTextField)
                || (target instanceof AbstractVRCheckBox)
                || (target instanceof AbstractVRComboBox)) {
            String bindPath = ((VRBindable) target).getBindPath();
            if (bindPath != null) {
                cachedControls.put(bindPath, target);
            }
        } else if (target instanceof Container) {
            int end = ((Container) target).getComponentCount();
            for (int i = 0; i < end; i++) {
                cacheComponentBindPath(((Container) target).getComponent(i));
            }
        }
    }

    class BindPathContainer {
        protected String name;
        protected String providerBindPath;

        public BindPathContainer(String name, String providerBindPath) {
            this.name = name;
            this.providerBindPath = providerBindPath;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setProviderBindPath(String bindPath) {
            this.providerBindPath = bindPath;
        }

        public String getProviderBindPath() {
            return this.providerBindPath;
        }
    }

    class BindPathPair extends BindPathContainer {
        private String serviceBindPath;

        public BindPathPair(String name, String providerBindPath,
                String serviceBindPath) {
            super(name, providerBindPath);
            this.serviceBindPath = serviceBindPath;
        }

        public void setServiceBindPath(String bindPath) {
            this.serviceBindPath = bindPath;
        }

        public String getServiceBindPath() {
            return this.serviceBindPath;
        }
    }

}
