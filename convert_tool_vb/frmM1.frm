VERSION 5.00
Object = "{F9043C88-F6F2-101A-A3C9-08002B2F49FB}#1.2#0"; "Comdlg32.ocx"
Object = "{248DD890-BB45-11CF-9ABC-0080C7E7B78D}#1.0#0"; "MSWINSCK.OCX"
Begin VB.Form frmM1 
   BorderStyle     =   1  '�Œ�(����)
   Caption         =   "���ǒ��f�[�^�ڍs�c�[��"
   ClientHeight    =   2055
   ClientLeft      =   45
   ClientTop       =   435
   ClientWidth     =   7365
   Icon            =   "frmM1.frx":0000
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   2055
   ScaleWidth      =   7365
   StartUpPosition =   2  '��ʂ̒���
   Begin VB.Frame shiftingFrame 
      Appearance      =   0  '�ׯ�
      BackColor       =   &H00FFC0C0&
      BorderStyle     =   0  '�Ȃ�
      ForeColor       =   &H80000008&
      Height          =   1815
      Left            =   120
      TabIndex        =   8
      Top             =   120
      Visible         =   0   'False
      Width           =   7095
      Begin VB.Label ConvMsg 
         Appearance      =   0  '�ׯ�
         BackColor       =   &H00E0E0E0&
         BeginProperty Font 
            Name            =   "�l�r �o�S�V�b�N"
            Size            =   20.25
            Charset         =   128
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H80000008&
         Height          =   975
         Left            =   120
         TabIndex        =   9
         Top             =   360
         Width           =   6855
      End
   End
   Begin MSWinsockLib.Winsock Winsock1 
      Left            =   5520
      Top             =   1800
      _ExtentX        =   741
      _ExtentY        =   741
      _Version        =   393216
   End
   Begin VB.Frame fraTo 
      Caption         =   "�ڍs��FDB�t�@�C��"
      Height          =   1035
      Left            =   120
      TabIndex        =   3
      Top             =   960
      Width           =   4815
      Begin VB.CommandButton btnTo 
         Caption         =   "..."
         Height          =   375
         Left            =   4200
         Picture         =   "frmM1.frx":08CA
         TabIndex        =   6
         Top             =   240
         Width           =   375
      End
      Begin VB.TextBox txtTo 
         Height          =   375
         Left            =   240
         TabIndex        =   4
         Top             =   240
         Width           =   3975
      End
      Begin VB.Label lblInfo 
         Caption         =   "�����{����܂ރt�@�C���p�X�͎w�肵�Ȃ��ł��������B"
         ForeColor       =   &H000000FF&
         Height          =   270
         Left            =   240
         TabIndex        =   7
         Top             =   720
         Width           =   4290
      End
   End
   Begin VB.Frame fraFrom 
      Caption         =   "�ڍs��QKN�t�@�C��"
      Height          =   735
      Left            =   120
      TabIndex        =   1
      Top             =   120
      Width           =   4815
      Begin VB.CommandButton btnFrom 
         Caption         =   "..."
         Height          =   375
         Left            =   4200
         Picture         =   "frmM1.frx":120E
         TabIndex        =   5
         Top             =   240
         Width           =   375
      End
      Begin VB.TextBox txtFrom 
         Height          =   375
         Left            =   240
         TabIndex        =   2
         Top             =   240
         Width           =   3975
      End
   End
   Begin VB.CommandButton btnStart 
      Caption         =   "�J�n"
      Height          =   1575
      Left            =   5040
      Picture         =   "frmM1.frx":1B52
      TabIndex        =   0
      Top             =   120
      Width           =   2175
   End
   Begin MSComDlg.CommonDialog dlgM1 
      Left            =   0
      Top             =   0
      _ExtentX        =   847
      _ExtentY        =   847
      _Version        =   393216
   End
End
Attribute VB_Name = "frmM1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit

Private Sub btnFrom_Click()

On Error GoTo Err_Cancel

    With frmM1
    
        .dlgM1.FileName = ""
        .dlgM1.CancelError = True
        .dlgM1.Filter = "Qkn�t�@�C���i*.qkn�j|*.qkn"
        .dlgM1.Flags = &H4
        .dlgM1.InitDir = VB.App.Path
        .dlgM1.ShowOpen
        
        .txtFrom.Text = .dlgM1.FileName
    
    End With
    
    Exit Sub
    
Err_Cancel:

End Sub

Private Sub btnTo_Click()

On Error GoTo Err_Cancel

    With frmM1
    
        .dlgM1.FileName = ""
        .dlgM1.CancelError = True
        .dlgM1.Filter = "Firebird Database File �i*.fdb�j|*.fdb"
        .dlgM1.Flags = &H4
        .dlgM1.InitDir = VB.App.Path & "\data"
        .dlgM1.ShowOpen
        
        .txtTo.Text = .dlgM1.FileName
    
    End With
    
    Exit Sub

Err_Cancel:

End Sub

Private Sub btnStart_Click()
Dim intVersion As Integer
Dim strMSG As String

    If MainCheck() Then
    
        '�J�n���b�Z�[�W
        'edit sta s-fujihara 2005/10/28 �f�[�^�x�[�X�t�@�C������̃t�@�C���ɒu�����鏈����ǉ�
        If MsgBox("�f�[�^�x�[�X�ڍs�������J�n���Ă�낵���ł����H" & _
        vbCrLf & "���V�o�[�W����(Ver4.5)�ɓo�^����Ă�����͍폜����܂��B" & vbCrLf & _
        "(���o�[�W�����̏��ɉe���͂���܂���j", vbYesNo + vbInformation, MSG_INFO) = vbNo Then
            Exit Sub
        End If
        'edit end s-fujihara 2005/10/28
        
        '�ڍs�����b�Z�[�W��\��
        shiftingFrame.Visible = True
        ConvMsg.Caption = "���ǒ��f�[�^" & vbNewLine & "�ڍs��......"
        frmM1.Refresh
        
        '���O�t�@�C���I�[�v��
        Call LogOpen
        
        '�����J�n
        Call LogWrite(Info, "======================�f�[�^�x�[�X�ڍs�����J�n======================")
    
        '�}�E�X�|�C���^���������ɕύX
        Screen.MousePointer = vbHourglass
    
        '�o�[�W�������擾
        intVersion = GetDBVersion()
        
        '�ڍs������ݒ�
        gNowDate = Now
        
        'edit sta s-fujihara 2005/10/28 �f�[�^�x�[�X�t�@�C������̃t�@�C���ɒu�����鏈����ǉ�
        '�o�[�W�����̎擾���s���Ă���΁A�t�@�C���̒u���������s��
        If intVersion <> DBVersion.UNKNOWN Then
            If Not basConvCommon.ReplaceFDBFile(frmM1.txtTo.Text) Then
                strMSG = "�f�[�^�x�[�X�t�@�C���̏������Ɏ��s���܂����B" & vbCrLf & "���ǒ������s���Ă���ꍇ�͏I�����Ă��������B"
                Call MsgBox(strMSG, vbCritical, MSG_EXCEPTIONSYSTEM)
                Call LogWrite(Error, strMSG)
                '�}�E�X�|�C���^����ɖ߂�
                Screen.MousePointer = vbDefault
                '���O�t�@�C���N���[�Y
                Call LogClose
                
                '�ڍs�����b�Z�[�W������
                shiftingFrame.Visible = False

                '�I��
                Exit Sub
            End If
        End If
        'edit end s-fujihara 2005/10/28
        
        '�o�[�W�������Ƃɏ�����U�蕪��
        Select Case intVersion
            
            Case DBVersion.VER20
                '���O�o��
                Call LogWrite(Info, "�ڍs�����ǒ��o�[�W����:Ver2.0")
                'Ver1.0�ڍs����
                Call Conv
            Case DBVersion.VER35
                '���O�o��
                Call LogWrite(Info, "�ڍs�����ǒ��o�[�W����:Ver3.5")
                'Ver3.5�ڍs����
                Call Conv
            Case DBVersion.UNKNOWN
                strMSG = "�ڍs���̋��ǒ��V�X�e���̃o�[�W�������ʂɎ��s���܂����B" & vbNewLine & "�ŐV�o�[�W�����ɃA�b�v�f�[�g���ĉ������B"
                Call MsgBox(strMSG, vbCritical, MSG_EXCEPTIONSYSTEM)
                '�A�v���b�g�А��f�[�^�x�[�X�X�L�[�}�\���ϊ��c�[�����N������B
                'Shell VB.App.Path & "\qkndbupd.exe", vbNormalFocus

                Call LogWrite(Error, strMSG)
                '�}�E�X�|�C���^����ɖ߂�
                Screen.MousePointer = vbDefault
                '�ڍs�����b�Z�[�W������
                shiftingFrame.Visible = False
                
                '���O�t�@�C���N���[�Y
                Call LogClose
                '�I��
                Exit Sub
        End Select
    
        '�}�E�X�|�C���^����ɖ߂�
        Screen.MousePointer = vbDefault
        
        '��������
        Call LogWrite(Info, "======================�f�[�^�x�[�X�ڍs��������======================")
        
        '���O�t�@�C���N���[�Y
        Call LogClose
        
        '�ڍs�����b�Z�[�W������
        shiftingFrame.Visible = False
        
        '�I�����b�Z�[�W
        Call MsgBox("�f�[�^�x�[�X�ڍs�������������܂����B", vbInformation, MSG_INFO)
    
    End If

End Sub

Private Sub Form_Load()
    '�A�v���P�[�V�����̃C���X�^���X�����Ɏ��s����Ă��邩
    '�ǂ����������l��Ԃ��܂��B
    If App.PrevInstance = True Then
    'True �̏ꍇ���łɋN����
        End
    End If

    'IBOLE.dll�̃��W�X�g���o�^
    Dim ret As Long
    'FireBird�Ƃ̐ڑ��p
    Dim dbConection As Boolean
    
    ret = Shell("regsvr32 /s " & """" & VB.App.Path & """" & "\IBOLE.dll")

    dbConection = False

    On Error GoTo ErrorHandler

    'FireBird�̃|�[�g���J����Ă邩�`�F�b�N
    Winsock1.Protocol = sckTCPProtocol
    Winsock1.LocalPort = "3050"

    Winsock1.Connect

    'FireBird�Ƃ̐ڑ����m�F���ꂽ��
    If dbConection = True Then
        
        Dim ini As String
        '�t�@�C���̑��݊m�F
        Dim strFilename As String
        
        'INI�t�@�C���p�X�擾
        gIniFilePath = VB.App.Path & "\" & VB.App.EXEName & ".ini"
    
        'INI�t�@�C�����݊m�F
        If Dir(gIniFilePath) = "" Then
            Call MsgBox("INI�t�@�C�����������Ă��������B", vbCritical, MSG_EXCEPTIONSYSTEM)
            Unload Me
        End If
    
        'FDB���[�U���擾
        ini = String(511, Chr$(0))
        Call GetPrivateProfileString("FDB", "User", "", ini, Len(ini) + 1, gIniFilePath)
        gFdbUser = Trim$(Replace(ini, Chr$(0), ""))
    
        'FDB�p�X���[�h�擾
        ini = String(511, Chr$(0))
        Call GetPrivateProfileString("FDB", "Password", "", ini, Len(ini) + 1, gIniFilePath)
        gFdbPassword = Trim$(Replace(ini, Chr$(0), ""))
    
        'qkn�t�@�C���̃f�t�H���g��ݒ�
        strFilename = VB.App.Path & "\conv.qkn"
        If Not Dir(strFilename, vbNormal Or vbSystem Or vbReadOnly Or vbArchive Or vbHidden) = "" Then
            frmM1.txtFrom.Text = strFilename
        End If
    
        'FDB�t�@�C���̃f�t�H���g��ݒ�
        strFilename = VB.App.Path & "\data\QKAN.FDB"
        If Not Dir(strFilename, vbNormal Or vbSystem Or vbReadOnly Or vbArchive Or vbHidden) = "" Then
            frmM1.txtTo.Text = strFilename
        End If
        
        Exit Sub
    'FireBird�Ƃ̐ڑ����m�F�ł��Ȃ����
    Else
        MsgBox "���ǒ�Ver4.5�̃f�[�^�x�[�X�Ƃ̐ڑ����o���܂���B" & vbNewLine & _
        "���g����PC�ŃZ�L�����e�B�΍�\�t�g�E�F�A�����g���̂��q�l�́A" & vbNewLine & _
        "�ʓr�A�Z�L�����e�B�΍�\�t�g�E�F�A�̃}�j���A����ǂ݁A�|�[�g�F3050��������ݒ���s���ĉ������B", vbOKOnly + vbExclamation, _
        "�f�[�^�x�[�X�ڑ��G���["

        End
    End If

ErrorHandler:
    dbConection = True
    Resume Next
End Sub


Private Sub Form_QueryUnload(Cancel As Integer, UnloadMode As Integer)

    Unload Me

End Sub
