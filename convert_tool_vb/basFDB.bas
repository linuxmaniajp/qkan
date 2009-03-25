Attribute VB_Name = "basDBMS_FDB"
Option Explicit
Private con As Object

Public Function FDBConnection(pstrConnectFile As String, pstrUserId As String, psrtPassword As String) As Boolean
'============================================================================================
'�R�l�N�V�����ڑ�
'============================================================================================
On Error GoTo Err_Connection

        FDBConnection = False

        '�t�@�C���p�X�m�F
        If Trim$(pstrConnectFile) = "" Then
            Exit Function
        End If
        
        '�t�@�C�����݊m�F
        If Trim$(Dir(pstrConnectFile)) = "" Then
            Exit Function
        End If

        '�R�l�N�V�����I�[�v��
        Set con = CreateObject("ADODB.Connection")
        con.Open "Provider=ZStyle IBOLE Provider;Password=" & psrtPassword & ";User ID=" & pstrUserId & ";Data Source=" & pstrConnectFile & ";"
        
        FDBConnection = True
        
        Exit Function
        
Err_Connection:

    '���O�o��
    Call LogWrite(Error, Err.Description)
    
    Call FDBUnConnection
    
    'FireBird�Ƃ̐ڑ��p
    Dim dbConection As Boolean
    
    dbConection = False

    On Error GoTo ErrorHandler

    'FireBird�̃|�[�g���J����Ă邩�`�F�b�N
    frmM1.Winsock1.Protocol = sckTCPProtocol
    frmM1.Winsock1.LocalPort = "3050"

    frmM1.Winsock1.Connect

    'FireBird�Ƃ̐ڑ����m�F���ꂽ��
    If dbConection = True Then
        MsgBox "���ǒ�Ver4.5�̃f�[�^�x�[�X�Ƃ̐ڑ��Ɏ��s���܂����B" & vbNewLine & VB.App.Path & _
        "�̒��ɂ���" & vbNewLine & vbNewLine & "�u�f�[�^�ڍs���s���Ɏ��s�p.bat�v" & vbNewLine & vbNewLine & "���_�u���N���b�N���āA�uIBOLE.dll��DllRegisterServer�͐������܂����B�v" & vbNewLine & _
        "���\������܂�����A�uOK�v�{�^�����N���b�N���A������x�f�[�^�ڍs���s���ĉ������B" & vbNewLine & _
        "���uOK�v�{�^�����N���b�N����ƃf�[�^�ڍs�c�[���͈�U�I�����܂��B", vbOKOnly + vbInformation, "���W�X�g���̓o�^�G���["
        
        '�o�b�`�t�@�C���̂���f�B���N�g�����J��
        Dim lngResult As Long
        lngResult = ShellExecute(frmM1.hwnd, "Explore", App.Path, vbNullString, vbNullString, 9)
        
        End
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
End Function

Public Function FDBUnConnection()
'============================================================================================
'�R�l�N�V��������
'============================================================================================
On Error GoTo Err_UnConnection
    
    con.Close
    Set con = Nothing
    
    Exit Function

Err_UnConnection:

    '���O�o��
    Call LogWrite(Error, Err.Description)

End Function

Public Function FDBExecuteRecordSet(ByVal pstrSQL As String, Optional ByVal plngCursorType As CursorTypeEnum = adOpenForwardOnly, Optional ByVal plngLockType As LockTypeEnum = adLockReadOnly) As Object
'============================================================================================
'���R�[�h�Z�b�g�擾
'============================================================================================
Dim rec As Object

On Error GoTo Err_OpenRecorSet
    
    '���R�[�h�Z�b�g�I�u�W�F�N�g�̐���
    Set rec = CreateObject("ADODB.Recordset")
    '���R�[�h�Z�b�g�̃I�[�v��
    rec.Open pstrSQL, con, plngCursorType, plngLockType
    '���R�[�h�Z�b�g��Ԃ�
    Set FDBExecuteRecordSet = rec
    
    Exit Function
        
Err_OpenRecorSet:

    Call LogWrite(Error, Err.Description & "," & pstrSQL)
    Set rec = Nothing

End Function

Public Function FDBExecuteSQL(ByVal pstrSQL As String) As Boolean
'============================================================================================
'SQL�����s����
'============================================================================================

On Error GoTo Err_Execute

    FDBExecuteSQL = False
        
    con.Execute pstrSQL

    FDBExecuteSQL = True
    Exit Function

Err_Execute:

    Call LogWrite(Error, Err.Description & "," & pstrSQL)

End Function

