Attribute VB_Name = "basMain"
Option Explicit

Public Const MSG_EXCEPTIONSYSTEM = "SystemException"
Public Const MSG_EXCEPTIONINFO = "InformationException"
Public Const MSG_INFO = "Information"

Public gCommandLine As String           '�R�}���h���C���ޔ�̈�
Public gIniFilePath As String           'INI�t�@�C���p�X
Public gNowDate As Date                 '�ڍs����

Public gFdbUser As String               'FDB���[�U��
Public gFdbPassword As String           'FDB�p�X���[�h

Public Enum DBVersion
    UNKNOWN = -1
    VER20 = 0
    VER35 = 1
End Enum

Public Function MainCheck() As Boolean
'============================================================================================
'�`�F�b�N����
'============================================================================================

    MainCheck = False

    With frmM1
    
        If Trim$(.txtFrom.Text) = "" Then
            Call MsgBox(.fraFrom.Caption & "�̏ꏊ�𐳂����w�肵�Ă��������B", vbInformation, MSG_EXCEPTIONINFO)
            .txtFrom.SetFocus
            Exit Function
        End If
    
        If Dir(Trim$(.txtFrom.Text)) = "" Then
            Call MsgBox(.fraFrom.Caption & "�Ɏw�肳�ꂽ�t�@�C���͑��݂��܂���B", vbInformation, MSG_EXCEPTIONINFO)
            .txtFrom.SetFocus
            Exit Function
        End If
    
        If Trim$(.txtTo.Text) = "" Then
            Call MsgBox(.fraTo.Caption & "�̏ꏊ�𐳂����w�肵�Ă��������B", vbInformation, MSG_EXCEPTIONINFO)
            .txtTo.SetFocus
            Exit Function
        End If
    
        If Dir(Trim$(.txtTo.Text)) = "" Then
            Call MsgBox(.fraTo.Caption & "�Ɏw�肳�ꂽ�t�@�C���͑��݂��܂���B", vbInformation, MSG_EXCEPTIONINFO)
            .txtTo.SetFocus
            Exit Function
        End If
    
        If Len(Trim$(.txtTo.Text)) <> LenB(StrConv(Trim$(.txtTo.Text), vbFromUnicode)) Then
            Call MsgBox(.fraTo.Caption & "�̃t�@�C���p�X�ɓ��{�ꂪ�܂܂�Ă��܂��B", vbInformation, MSG_EXCEPTIONINFO)
            .txtTo.SetFocus
            Exit Function
        End If
    
    End With
    
    MainCheck = True

End Function

Public Function GetDBVersion() As DBVersion
'============================================================================================
'DB�o�[�W�������擾
'============================================================================================
Dim recVERSION As Object
Dim strSQL As String

    GetDBVersion = UNKNOWN
    '�R�l�N�V�����ڑ�
    Call MDBConnection(Trim$(frmM1.txtFrom.Text))
    
    '�o�[�W�������e�[�u���̎擾
    Set recVERSION = MDBExecuteRecordSet("SELECT [_value] FROM m_db_info WHERE [_section]='db' AND [_key]='version'", adOpenForwardOnly, adLockReadOnly)

    If recVERSION(0) = "2.02.00" Then
        GetDBVersion = VER20
    ElseIf recVERSION(0) = "3.05.00" Then
        GetDBVersion = VER35
    End If

    '�R�l�N�V�����ؒf
    'Call MDBUnConnection
    
End Function

Public Sub Conv()
'============================================================================================
'�ڍs����
'============================================================================================
    With frmM1
        '�R�l�N�V�����ڑ�
        Call MDBConnection(Trim$(.txtFrom.Text))
        Call FDBConnection(Trim$(.txtTo.Text), gFdbUser, gFdbPassword)
 
        '�ی��ҏ��ڍs
        Call ConvINSURER
        '�Z���E�{�ݓ������ڍs
        If GetDBVersion = VER35 Then
            Call ConvProviderInfo
        End If
        '���ҏ��ڍs
        Call ConvPATIENT
        '���Ə����ڍs
        Call ConvPROVIDER
        '���Ə��T�[�r�X�ڍs
        Call ConvPROVIDERSERVICE
        
        '����×{�Ǘ��w����
        Call ConvKYOTAKURYOYO
        '�K��Ō�v�揑
        Call ConvHOMONKANGOPLAN
        '�K��Ō�񍐏�
        Call ConvHOMONKANGORESULT
        
        '�R�l�N�V�����ؒf
        Call MDBUnConnection
        Call FDBUnConnection
    
    End With

End Sub
