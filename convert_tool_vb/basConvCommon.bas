Attribute VB_Name = "basConvCommon"
Option Explicit

Public Sub ConvHOMONKANGORESULT()
'============================================================================================
'�K��Ō�񍐏����ڍs�i�S���ʁj
'============================================================================================
Dim recHOMONKANGORESULT As Object
Dim recHOMONKANGORESULT_New As Object
Dim strSQL As String
Dim strSQLCalender As String
Dim i As Integer

    '�G���[����
    On Error GoTo Err_Connection
    

    '�K��Ō�񍐏����e�[�u���̎擾
    Set recHOMONKANGORESULT = MDBExecuteRecordSet("SELECT * FROM f07 order by ID DESC", adOpenForwardOnly, adLockReadOnly)

    '�K��Ō�񍐏���񐔕���������
    Do Until recHOMONKANGORESULT.EOF
        '5.0�̃f�[�^�̗L�����`�F�b�N
        Set recHOMONKANGORESULT_New = FDBExecuteRecordSet("SELECT * FROM HOMONKANGO_RESULT WHERE " & _
        "PATIENT_ID=" & recHOMONKANGORESULT("pat_id") & " AND TARGET_DATE= " & "'" & recHOMONKANGORESULT("d02") & "'", _
        adOpenForwardOnly, adLockReadOnly)
    
        If recHOMONKANGORESULT_New.EOF Then
            '�K��Ō�񍐏����e�[�u�����ڍs
            strSQL = ""
            strSQL = strSQL & "INSERT INTO HOMONKANGO_RESULT ("
            strSQL = strSQL & "PATIENT_ID,"
            strSQL = strSQL & "TARGET_DATE,"
            strSQL = strSQL & "JOTAI_CODE,"
            strSQL = strSQL & "DOCTOR_NAME,"
            strSQL = strSQL & "CREATE_DATE,"
            strSQL = strSQL & "PROVIDER_NAME,"
            strSQL = strSQL & "ADMINISTRATOR_NAME,"
            strSQL = strSQL & "BYOJO_STATE,"
            strSQL = strSQL & "KANGO_REHA_NAIYO,"
            strSQL = strSQL & "RYOYO_KAIGO_STATE,"
            strSQL = strSQL & "REPORT_COMMENT,"
            strSQL = strSQL & "LAST_TIME"
            strSQL = strSQL & ")"
            
            strSQL = strSQL & " VALUES ("
            '���p��ID�̃f�[�^�ڍs
            strSQL = strSQL & recHOMONKANGORESULT("pat_id") & ","
            '�Ώ۔N���̃f�[�^�ڍs
            strSQL = strSQL & "'" & recHOMONKANGORESULT("d02") & "',"
            '�v���x�̃f�[�^�ڍs
            'NULL�̎���0���ڍs
            If IsNull(recHOMONKANGORESULT("o10")) Then
                strSQL = strSQL & "0,"
            'NULL�łȂ���
            Else
                '�ڍs���f�[�^��0�̎���1�i�����j�ɕύX���A�f�[�^�ڍs
                If recHOMONKANGORESULT("o10") = 0 Then
                    strSQL = strSQL & "1,"
                '�ڍs���f�[�^��1�̎���11�i�v�x���j�ɕύX���A�f�[�^�ڍs
                ElseIf recHOMONKANGORESULT("o10") = 1 Then
                    strSQL = strSQL & "11,"
                '�ڍs���f�[�^��2�̎���21�i�v���1�j�ɕύX���A�f�[�^�ڍs
                ElseIf recHOMONKANGORESULT("o10") = 2 Then
                    strSQL = strSQL & "21,"
                '�ڍs���f�[�^��3�̎���22�i�v���2�j�ɕύX���A�f�[�^�ڍs
                ElseIf recHOMONKANGORESULT("o10") = 3 Then
                    strSQL = strSQL & "22,"
                '�ڍs���f�[�^��4�̎���23�i�v���3�j�ɕύX���A�f�[�^�ڍs
                ElseIf recHOMONKANGORESULT("o10") = 4 Then
                    strSQL = strSQL & "23,"
                '�ڍs���f�[�^��5�̎���24�i�v���4�j�ɕύX���A�f�[�^�ڍs
                ElseIf recHOMONKANGORESULT("o10") = 5 Then
                    strSQL = strSQL & "24,"
                '�ڍs���f�[�^��6�̎���25�i�v���5�j�ɕύX���A�f�[�^�ڍs
                ElseIf recHOMONKANGORESULT("o10") = 6 Then
                    strSQL = strSQL & "25,"
                End If
            End If
            '��t�����̃f�[�^���ڍs
            'NULL�̎�
            If IsNull(recHOMONKANGORESULT("t04")) Then
                strSQL = strSQL & "'',"
            Else
                '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGORESULT("t04"), 32), "'", "''") & "',"
            End If
            '�쐬�N�����̃f�[�^���ڍs
            'NULL�̎��́ANULL�������ڍs
            If IsNull(recHOMONKANGORESULT("d01")) Then
                strSQL = strSQL & "NULL" & ","
            'NULL�łȂ����́A�쐬�N�����̃f�[�^���ڍs
            Else
                strSQL = strSQL & "'" & recHOMONKANGORESULT("d01") & "',"
            End If
            '���Ə����̂̃f�[�^���ڍs
            'NULL�̂Ƃ�
            If IsNull(recHOMONKANGORESULT("t03")) Then
                strSQL = strSQL & "'',"
            Else
                '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGORESULT("t03"), 64), "'", "''") & "',"
            End If
            '�Ǘ��Ҏ����̃f�[�^���ڍs
            'NULL�̂Ƃ�
            If IsNull(recHOMONKANGORESULT("t02")) Then
                strSQL = strSQL & "'',"
            Else
                '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGORESULT("t02"), 22), "'", "''") & "',"
            End If
            '�a��̌o�߂̃f�[�^���ڍs
            'NULL�̂Ƃ�
            If IsNull(recHOMONKANGORESULT("t05")) Then
                strSQL = strSQL & "'',"
            Else
                '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGORESULT("t05"), 294), "'", "''") & "',"
            End If
            '�Ō�E���n�r���e�[�V�����̃f�[�^���ڍs
            'NULL�̂Ƃ�
            If IsNull(recHOMONKANGORESULT("t06")) Then
                strSQL = strSQL & "'',"
            Else
                '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGORESULT("t06"), 378), "'", "''") & "',"
            End If
            '�ƒ�ł̗×{�E�Ō�̏󋵂̃f�[�^���ڍs
            'NULL�̂Ƃ�
            If IsNull(recHOMONKANGORESULT("t07")) Then
                 strSQL = strSQL & "'',"
            Else
                '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGORESULT("t07"), 336), "'", "''") & "',"
            End If
            '���L���ׂ������̃f�[�^���ڍs
            'NULL�̂Ƃ�
            If IsNull(recHOMONKANGORESULT("t08")) Then
                strSQL = strSQL & "'',"
            Else
                '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGORESULT("t08"), 240), "'", "''") & "',"
            End If
            '�ŏI�X�V���ɃV�X�e�����t��o�^
            strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
            strSQL = strSQL & ")"
            Call FDBExecuteSQL(strSQL)
            
            '�K��Ō�񍐏��i�J�����_�[�j���e�[�u�����ڍs
            '�쐬�N�����̖��������[�v�������s��
            For i = 1 To Day(DateAdd("d", -1, DateAdd("m", 1, recHOMONKANGORESULT("d02"))))
                strSQLCalender = ""
                strSQLCalender = strSQLCalender & "INSERT INTO HOMONKANGO_RESULT_CALENDAR ("
                strSQLCalender = strSQLCalender & "PATIENT_ID,"
                strSQLCalender = strSQLCalender & "VISIT_DATE,"
                strSQLCalender = strSQLCalender & "VISIT_VALUE,"
                strSQLCalender = strSQLCalender & "LAST_TIME"
                strSQLCalender = strSQLCalender & ")"
                
                strSQLCalender = strSQLCalender & " VALUES ("
                '���p��ID�̃f�[�^���ڍs����
                strSQLCalender = strSQLCalender & recHOMONKANGORESULT("pat_id") & ","
                '�K��N���̃f�[�^���ڍs����
                '�쐬�N�������N�����擾���A���[�v�̃J�E���g����Ƃ��A���t�^�Ńt�H�[�}�b�g���s��
                strSQLCalender = strSQLCalender & "'" & Format(Format(recHOMONKANGORESULT("d02"), "yyyy/mm") & "/" & i, "yyyy/mm/dd") & "',"
                '�K����т̃f�[�^���ڍs����
                '�ڍs���f�[�^��0�̎��A1�ɕϊ����A�f�[�^���ڍs
                If Mid(recHOMONKANGORESULT("b00"), i, 1) = 0 Then
                    strSQLCalender = strSQLCalender & "1,"
                '�ڍs���f�[�^��1��6�̎��A2�ɕϊ����A�f�[�^���ڍs
                ElseIf Mid(recHOMONKANGORESULT("b00"), i, 1) = 1 Or Mid(recHOMONKANGORESULT("b00"), i, 1) = 6 Then
                    strSQLCalender = strSQLCalender & "2,"
                '�ڍs���f�[�^��2��7�̎��A3�ɕϊ����A�f�[�^���ڍs
                ElseIf Mid(recHOMONKANGORESULT("b00"), i, 1) = 2 Or Mid(recHOMONKANGORESULT("b00"), i, 1) = 7 Then
                    strSQLCalender = strSQLCalender & "3,"
                '�ڍs���f�[�^��3�̎��A5�ɕϊ����A�f�[�^���ڍs
                ElseIf Mid(recHOMONKANGORESULT("b00"), i, 1) = 3 Then
                    strSQLCalender = strSQLCalender & "5,"
                '�ڍs���f�[�^��5�̎��A4�ɕϊ����A�f�[�^���ڍs
                ElseIf Mid(recHOMONKANGORESULT("b00"), i, 1) = 5 Then
                    strSQLCalender = strSQLCalender & "4,"
                End If
                '�ŏI�X�V���ɃV�X�e�����t��o�^
                strSQLCalender = strSQLCalender & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
                strSQLCalender = strSQLCalender & ")"
                
                Call FDBExecuteSQL(strSQLCalender)
            Next i
            '�쐬�N�����̎����̖��������[�v�������s��
'            For i = 1 To Day(DateAdd("d", -1, DateAdd("m", 2, recHOMONKANGORESULT("d02"))))
'                strSQLCalender = ""
'                strSQLCalender = strSQLCalender & "INSERT INTO HOMONKANGO_RESULT_CALENDAR ("
'                strSQLCalender = strSQLCalender & "PATIENT_ID,"
'                strSQLCalender = strSQLCalender & "VISIT_DATE,"
'                strSQLCalender = strSQLCalender & "VISIT_VALUE,"
'                strSQLCalender = strSQLCalender & "LAST_TIME"
'                strSQLCalender = strSQLCalender & ")"
'
'                strSQLCalender = strSQLCalender & " VALUES ("
'                '���p��ID�̃f�[�^���ڍs����
'                strSQLCalender = strSQLCalender & recHOMONKANGORESULT("pat_id") & ","
'                '�K��N���̃f�[�^���ڍs����
'                '�쐬�N�����̔N����DateAdd�֐��ɂ�莟���ɂ��A���[�v�̃J�E���g����Ƃ��A���t�^�Ńt�H�[�}�b�g���s��
'                strSQLCalender = strSQLCalender & "'" & Format(Format(DateAdd("m", 1, recHOMONKANGORESULT("d02")), "yyyy/mm") & "/" & i, "yyyy/mm/dd") & "',"
'                '�K����т̃f�[�^���ڍs����
'                '�ڍs���f�[�^��0�̎��A1�ɕϊ����A�f�[�^���ڍs
'                If Mid(recHOMONKANGORESULT("b01"), i, 1) = 0 Then
'                    strSQLCalender = strSQLCalender & "1,"
'                '�ڍs���f�[�^��1��6�̎��A2�ɕϊ����A�f�[�^���ڍs
'                ElseIf Mid(recHOMONKANGORESULT("b01"), i, 1) = 1 Or Mid(recHOMONKANGORESULT("b01"), i, 1) = 6 Then
'                    strSQLCalender = strSQLCalender & "2,"
'                '�ڍs���f�[�^��2��7�̎��A3�ɕϊ����A�f�[�^���ڍs
'                ElseIf Mid(recHOMONKANGORESULT("b01"), i, 1) = 2 Or Mid(recHOMONKANGORESULT("b01"), i, 1) = 7 Then
'                    strSQLCalender = strSQLCalender & "3,"
'                '�ڍs���f�[�^��3�̎��A5�ɕϊ����A�f�[�^���ڍs
'                ElseIf Mid(recHOMONKANGORESULT("b01"), i, 1) = 3 Then
'                    strSQLCalender = strSQLCalender & "5,"
'                '�ڍs���f�[�^��5�̎��A4�ɕϊ����A�f�[�^���ڍs
'                ElseIf Mid(recHOMONKANGORESULT("b01"), i, 1) = 5 Then
'                    strSQLCalender = strSQLCalender & "4,"
'                End If
'                '�ŏI�X�V���ɃV�X�e�����t��o�^
'                strSQLCalender = strSQLCalender & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
'                strSQLCalender = strSQLCalender & ")"
'
'                Call FDBExecuteSQL(strSQLCalender)
'            Next i
        
        End If
        recHOMONKANGORESULT.MoveNext
    Loop
    
    Exit Sub

Err_Connection:

    MsgBox "�f�[�^�̈ڍs�Ɏ��s���܂����B" & vbNewLine & "�\���󂠂�܂��񂪁A�f�[�^�̈ڍs���͂��߂����蒼���Ă��������B" _
    , vbInformation + vbOKOnly, "�f�[�^�ڍs���s"
    
    End

End Sub

Public Sub ConvHOMONKANGOPLAN()
'============================================================================================
'�K��Ō�v�揑���ڍs�i�S���ʁj
'============================================================================================
Dim recHOMONKANGOPLAN As Object
Dim recHOMONKANGOPLAN_New As Object
Dim recHOMONKANGOPLANNOTE As Object
Dim strSQL As String
Dim strSQLNote As String
Dim intNoteID As Integer
'���p�Ҕԍ���old�i�[�ϐ�
Dim intPatientID_old As Integer

    '�}�Ԃ̏�����
    intNoteID = 1
    
    '�G���[����
    On Error GoTo Err_Connection

    '�K��Ō�v�揑���e�[�u���̎擾
    Set recHOMONKANGOPLAN = MDBExecuteRecordSet("SELECT * FROM f08 order by ID DESC", adOpenForwardOnly, adLockReadOnly)

    '�K��Ō�v�揑��񐔕���������
    Do Until recHOMONKANGOPLAN.EOF
        '5.0�̃f�[�^�̗L�����`�F�b�N
        Set recHOMONKANGOPLAN_New = FDBExecuteRecordSet("SELECT * FROM HOMONKANGO_PLAN WHERE " & _
        "PATIENT_ID=" & recHOMONKANGOPLAN("pat_id"), adOpenForwardOnly, adLockReadOnly)
        '"PATIENT_ID=" & recHOMONKANGOPLAN("pat_id") & " AND TARGET_DATE= " & "'" & Format(recHOMONKANGOPLAN("d01"), "yyyy/mm") & "/" & "01" & "'",
    
        If recHOMONKANGOPLAN_New.EOF Then
            '���p��ID��old�ԍ�����
            intPatientID_old = recHOMONKANGOPLAN("pat_id")
        
            '�K��Ō�v�揑���e�[�u�����ڍs
            strSQL = ""
            strSQL = strSQL & "INSERT INTO HOMONKANGO_PLAN ("
            strSQL = strSQL & "PATIENT_ID,"
            strSQL = strSQL & "TARGET_DATE,"
            strSQL = strSQL & "JOTAI_CODE,"
            strSQL = strSQL & "DOCTOR_NAME,"
            strSQL = strSQL & "CREATE_DATE,"
            strSQL = strSQL & "PROVIDER_NAME,"
            strSQL = strSQL & "ADMINISTRATOR_NAME,"
            strSQL = strSQL & "PLAN_PURPOSE,"
            strSQL = strSQL & "PLAN_COMMENT,"
            strSQL = strSQL & "LAST_TIME"
            strSQL = strSQL & ")"
            
            strSQL = strSQL & " VALUES ("
            '���p��ID�̃f�[�^���ڍs
            strSQL = strSQL & recHOMONKANGOPLAN("pat_id") & ","
            '�Ώ۔N���̃f�[�^���ڍs
            strSQL = strSQL & "'" & Format(recHOMONKANGOPLAN("d01"), "yyyy/mm") & "/" & "01" & "',"
            '�v���x�̃f�[�^���ڍs
            'NULL�̎��́A�u0�v���ڍs
            If IsNull(recHOMONKANGOPLAN("o10")) Then
                strSQL = strSQL & "0,"
            Else
                '�v���x���u0�v�̎��́A�u1�v�������ڍs
                If recHOMONKANGOPLAN("o10") = 0 Then
                    strSQL = strSQL & "1,"
                '�v���x���u1�v�̎��́A�u11�v�v�x�����ڍs
                ElseIf recHOMONKANGOPLAN("o10") = 1 Then
                    strSQL = strSQL & "11,"
                '�v���x���u2�v�̎��́A�u21�v�v���1���ڍs
                ElseIf recHOMONKANGOPLAN("o10") = 2 Then
                    strSQL = strSQL & "21,"
                '�v���x���u3�v�̎��́A�u22�v�v���2���ڍs
                ElseIf recHOMONKANGOPLAN("o10") = 3 Then
                    strSQL = strSQL & "22,"
                '�v���x���u4�v�̎��́A�u23�v�v���3���ڍs
                ElseIf recHOMONKANGOPLAN("o10") = 4 Then
                    strSQL = strSQL & "23,"
                '�v���x���u5�v�̎��́A�u24�v�v���4���ڍs
                ElseIf recHOMONKANGOPLAN("o10") = 5 Then
                    strSQL = strSQL & "24,"
                '�v���x���u6�v�̎��́A�u25�v�v���5���ڍs
                ElseIf recHOMONKANGOPLAN("o10") = 6 Then
                    strSQL = strSQL & "25,"
                End If
            End If
            '��t�����̃f�[�^���ڍs
            'NULL�̂Ƃ�
            If IsNull(recHOMONKANGOPLAN("t04")) Then
                strSQL = strSQL & "'',"
            Else
                '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
                strSQL = strSQL & "'" & Replace(recHOMONKANGOPLAN("t04"), "'", "''") & "',"
            End If
            '�쐬�N�����̃f�[�^���ڍs
            'NULL�̎��́A�uNULL�v�������ڍs
            If IsNull(recHOMONKANGOPLAN("d01")) Then
                strSQL = strSQL & "NULL" & ","
            Else
                '�쐬�N�����̃f�[�^���ڍs
                strSQL = strSQL & "'" & recHOMONKANGOPLAN("d01") & "',"
            End If
            '���Ə������̃f�[�^���ڍs
            'NULL�̂Ƃ�
            If IsNull(recHOMONKANGOPLAN("t03")) Then
                strSQL = strSQL & "'',"
            Else
                '�ڍs���f�[�^�̈ڍs�i�V���O���N�H�[�g��u���j
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGOPLAN("t03"), 64), "'", "''") & "',"
            End If
            '�Ǘ��Ҏ����̃f�[�^���ڍs
            'NULL�̂Ƃ�
            If IsNull(recHOMONKANGOPLAN("t02")) Then
                strSQL = strSQL & "'',"
            Else
                '�ڍs���f�[�^�̈ڍs�i�V���O���N�H�[�g��u���j
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGOPLAN("t02"), 22), "'", "''") & "',"
            End If
            '�Ō�E���n�r���e�[�V�����̖ڕW�̃f�[�^���ڍs
            'NULL�̂Ƃ�
            If IsNull(recHOMONKANGOPLAN("t05")) Then
                strSQL = strSQL & "'',"
            Else
                '�ڍs���f�[�^�̈ڍs�i�V���O���N�H�[�g��u���j
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGOPLAN("t05"), 572), "'", "''") & "',"
            End If
            '���l�̃f�[�^���ڍs
            If IsNull(recHOMONKANGOPLAN("t06")) Then
                strSQL = strSQL & "'',"
            Else
                '�ڍs���f�[�^�̈ڍs�i�V���O���N�H�[�g��u���j
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGOPLAN("t06"), 172), "'", "''") & "',"
            End If
            '�ŏI�X�V���ɃV�X�e�����t��o�^
            strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
            strSQL = strSQL & ")"
            Call FDBExecuteSQL(strSQL)
            
            '�K��Ō�v�揑�i���E�Ή���j���e�[�u���̎擾
            Set recHOMONKANGOPLANNOTE = MDBExecuteRecordSet("SELECT * FROM f08sub WHERE " & _
            "F8_ID =" & recHOMONKANGOPLAN("ID") & "", adOpenForwardOnly, adLockReadOnly)
            
            '�K��Ō�v�揑�i���E�Ή���j���̃f�[�^�����[�v����
            Do Until recHOMONKANGOPLANNOTE.EOF
                '�쐬�N������NULL�Ŗ�����΁A�f�[�^�ڍs���s��
                If Not IsNull(recHOMONKANGOPLANNOTE("d00")) Then
                    '�}�Ԃ̏�����<���p��ID��old�ԍ����Ⴄ�Ƃ�>
                    If recHOMONKANGOPLAN("pat_id") <> intPatientID_old Then
                        intNoteID = 1
                    End If

                    strSQLNote = ""
                    strSQLNote = strSQLNote & "INSERT INTO HOMONKANGO_PLAN_NOTE ("
                    strSQLNote = strSQLNote & "PATIENT_ID,"
                    strSQLNote = strSQLNote & "NOTE_ID,"
                    strSQLNote = strSQLNote & "NOTE_DATE,"
                    strSQLNote = strSQLNote & "NOTE_COMMENT,"
                    strSQLNote = strSQLNote & "LAST_TIME"
                    strSQLNote = strSQLNote & ")"
                    
                    strSQLNote = strSQLNote & " VALUES ("
                    '���p��ID�̃f�[�^���ڍs
                    strSQLNote = strSQLNote & recHOMONKANGOPLAN("pat_id") & ","
                    '�}�Ԃ̃f�[�^��o�^
                    strSQLNote = strSQLNote & intNoteID & ","
                    '���_�E������E���t�̃f�[�^���ڍs
                    'NULL�̎�
                    If IsNull(recHOMONKANGOPLANNOTE("d00")) Then
                        '�uNULL�v�������ڍs
                        strSQLNote = strSQLNote & "NULL" & ","
                    'NULL�łȂ���
                    Else
                        '���_�E������E���t�̃f�[�^���ڍs
                        strSQLNote = strSQLNote & "'" & recHOMONKANGOPLANNOTE("d00") & "',"
                    End If
                    '���_�E������E���e�̃f�[�^���ڍs
                    'NULL�̎�
                    If IsNull(recHOMONKANGOPLANNOTE("t00")) Then
                        strSQLNote = strSQLNote & "'',"
                    Else
                        '�ڍs���f�[�^�̈ڍs�i�V���O���N�H�[�g��u���j
                        strSQLNote = strSQLNote & "'" & Replace(Left(recHOMONKANGOPLANNOTE("t00"), 3000), "'", "''") & "',"
                    End If
                    '�ŏI�X�V���ɃV�X�e�����t��o�^
                    strSQLNote = strSQLNote & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
                    strSQLNote = strSQLNote & ")"
                    Call FDBExecuteSQL(strSQLNote)
                        
                    '�}�Ԃ�1������
                    intNoteID = intNoteID + 1
                End If
                recHOMONKANGOPLANNOTE.MoveNext
            Loop
        End If
        recHOMONKANGOPLAN.MoveNext
    Loop
    
    Exit Sub
    
Err_Connection:

    MsgBox "�f�[�^�̈ڍs�Ɏ��s���܂����B" & vbNewLine & "�\���󂠂�܂��񂪁A�f�[�^�̈ڍs���͂��߂����蒼���Ă��������B" _
    , vbInformation + vbOKOnly, "�f�[�^�ڍs���s"
    
    End

End Sub

Public Sub ConvKYOTAKURYOYO()
'============================================================================================
'����×{�Ǘ��w�������ڍs�i�S���ʁj
'============================================================================================
Dim recKYOTAKURYOYO As Object
Dim recKYOTAKURYOYO_New As Object
Dim strSQL As String
Dim varThisMonth As Variant
Dim varNextMonth As Variant

    '�G���[����
    On Error GoTo Err_Connection

    '����×{�Ǘ��w�������e�[�u���̎擾
    Set recKYOTAKURYOYO = MDBExecuteRecordSet("SELECT * FROM f04b order by ID DESC", adOpenForwardOnly, adLockReadOnly)

    '����×{�Ǘ��w������񐔕���������
    Do Until recKYOTAKURYOYO.EOF
        '5.0�̃f�[�^�̗L�����`�F�b�N
        Set recKYOTAKURYOYO_New = FDBExecuteRecordSet("SELECT * FROM KYOTAKU_RYOYO WHERE " & _
        "PATIENT_ID=" & recKYOTAKURYOYO("pat_id") & " AND TARGET_DATE= " & "'" & recKYOTAKURYOYO("d00") & "'", _
        adOpenForwardOnly, adLockReadOnly)
    
        If recKYOTAKURYOYO_New.EOF Then
            '����×{�Ǘ��w�������e�[�u�����ڍs
            strSQL = ""
            strSQL = strSQL & "INSERT INTO KYOTAKU_RYOYO ("
            strSQL = strSQL & "PATIENT_ID,"
            strSQL = strSQL & "TARGET_DATE,"
            strSQL = strSQL & "JOTAI_CODE,"
            'strSQL = strSQL & "DISEASE_NAME,"
            'strSQL = strSQL & "DISEASE_DATE,"
            strSQL = strSQL & "SHOGAI_JIRITSUDO,"
            strSQL = strSQL & "NINCHISHO_JIRITSUDO,"
            strSQL = strSQL & "CREATE_DATE_ZAITAKU,"
            strSQL = strSQL & "VISIT_THIS_MONTH_NO1,"
            strSQL = strSQL & "VISIT_THIS_MONTH_NO2,"
            strSQL = strSQL & "VISIT_THIS_MONTH_NO3,"
            strSQL = strSQL & "VISIT_THIS_MONTH_NO4,"
            strSQL = strSQL & "VISIT_THIS_MONTH_NO5,"
            strSQL = strSQL & "VISIT_THIS_MONTH_NO6,"
            strSQL = strSQL & "VISIT_NEXT_MONTH_NO1,"
            strSQL = strSQL & "VISIT_NEXT_MONTH_NO2,"
            strSQL = strSQL & "VISIT_NEXT_MONTH_NO3,"
            strSQL = strSQL & "VISIT_NEXT_MONTH_NO4,"
            strSQL = strSQL & "VISIT_NEXT_MONTH_NO5,"
            strSQL = strSQL & "VISIT_NEXT_MONTH_NO6,"
            strSQL = strSQL & "ADVICE_MONTH,"
            strSQL = strSQL & "ADVICE,"
            strSQL = strSQL & "MEDICAL_FACILITY_NAME,"
            strSQL = strSQL & "DOCTOR_NAME,"
            'strSQL = strSQL & "RENRAKUSAKI,"
            strSQL = strSQL & "SENMONIN,"
            strSQL = strSQL & "PROVIDER_NAME,"
            strSQL = strSQL & "CREATE_DATE_KYOTAKU,"
'            strSQL = strSQL & "BYOJO_STATE,"
'            strSQL = strSQL & "BYOJO_DETAIL,"
'            strSQL = strSQL & "BYOJO_COMMENT,"
'            strSQL = strSQL & "MENTAL_STATE,"
'            strSQL = strSQL & "MENTAL_DETAIL,"
'            strSQL = strSQL & "MENTAL_COMMENT,"
'            strSQL = strSQL & "MOVE_STATE,"
'            strSQL = strSQL & "MOVE_COMMENT,"
'            strSQL = strSQL & "SESSHOKU_STATE,"
'            strSQL = strSQL & "SESSHOKU_DETAIL,"
'            strSQL = strSQL & "SESSHOKU_COMMENT,"
'            strSQL = strSQL & "BATH_STATE,"
'            strSQL = strSQL & "BATH_DETAIL,"
'            strSQL = strSQL & "BATH_COMMENT,"
'            strSQL = strSQL & "EXTRA_STATE_BLOOD_PRESSURE,"
'            strSQL = strSQL & "EXTRA_STATE_DIABETES,"
'            strSQL = strSQL & "EXTRA_STATE_BODY_TEMPERATURE,"
'            strSQL = strSQL & "EXTRA_BLOOD_PRESSURE_H,"
'            strSQL = strSQL & "EXTRA_BLOOD_PRESSURE_L,"
'            strSQL = strSQL & "EXTRA_BODY_TEMPERATURE,"
'            strSQL = strSQL & "EXTRA_COMMENT,"
'            strSQL = strSQL & "TEIJI_SHOHO_NAIYO,"
'            strSQL = strSQL & "RIYOSHA_SHIJI_NAIYO,"
            strSQL = strSQL & "LAST_TIME"
            strSQL = strSQL & ")"
            
            strSQL = strSQL & " VALUES ("
            '���p��ID�̃f�[�^���ڍs
            strSQL = strSQL & recKYOTAKURYOYO("pat_id") & ","
            '�Ώ۔N���̃f�[�^���ڍs
            strSQL = strSQL & "'" & recKYOTAKURYOYO("d00") & "',"
            '�v���x�̃f�[�^���ڍs
            '�uNULL�v�̎��A�uNULL�v�������ڍs
            If IsNull(recKYOTAKURYOYO("o010")) Then
                strSQL = strSQL & "0,"
            Else
                '�v���x�̃f�[�^���u1�v�̎��A�u11�v�v�x�����ڍs
                If recKYOTAKURYOYO("o010") = 1 Then
                    strSQL = strSQL & "11,"
                '�v���x�̃f�[�^���u2�v�̎��A�u21�v�v���1���ڍs
                ElseIf recKYOTAKURYOYO("o010") = 2 Then
                    strSQL = strSQL & "21,"
                '�v���x�̃f�[�^���u3�v�̎��A�u22�v�v���2���ڍs
                ElseIf recKYOTAKURYOYO("o010") = 3 Then
                    strSQL = strSQL & "22,"
                '�v���x�̃f�[�^���u4�v�̎��A�u23�v�v���3���ڍs
                ElseIf recKYOTAKURYOYO("o010") = 4 Then
                    strSQL = strSQL & "23,"
                '�v���x�̃f�[�^���u5�v�̎��A�u24�v�v���4���ڍs
                ElseIf recKYOTAKURYOYO("o010") = 5 Then
                    strSQL = strSQL & "24,"
                '�v���x�̃f�[�^���u6�v�̎��A�u25�v�v���5���ڍs
                ElseIf recKYOTAKURYOYO("o010") = 6 Then
                    strSQL = strSQL & "25,"
                Else
                    strSQL = strSQL & "0,"
                End If
            End If
            '��a���̃f�[�^���ڍs
            'strSQL = strSQL & "'" & recKYOTAKURYOYO("t09") & "',"
            '���˔N�����̃f�[�^���ڍs
            'NULL�̎��A�uNULL�v�������ڍs
            'If IsNull(recKYOTAKURYOYO("d03")) Then
            '    strSQL = strSQL & "NULL" & ","
            'Else
                '���˔N�����̃f�[�^���ڍs
            '    strSQL = strSQL & "'" & recKYOTAKURYOYO("d03") & "',"
            'End If
            '��Q����ғ��퐶�������x�̃f�[�^�ڍs
            'NULL�̎��A�uNULL�v�������ڍs
            If IsNull(recKYOTAKURYOYO("o020")) Then
                strSQL = strSQL & "NULL" & ","
            Else
                '��Q����ғ��퐶�������x�̃f�[�^���ڍs
                If recKYOTAKURYOYO("o020") = 1 Then
                    strSQL = strSQL & 1 & ","
                ElseIf recKYOTAKURYOYO("o020") < 4 And recKYOTAKURYOYO("o020") <> 0 Then
                    strSQL = strSQL & 2 & ","
                ElseIf recKYOTAKURYOYO("o020") < 6 And recKYOTAKURYOYO("o020") <> 0 Then
                    strSQL = strSQL & 3 & ","
                ElseIf recKYOTAKURYOYO("o020") < 8 And recKYOTAKURYOYO("o020") <> 0 Then
                    strSQL = strSQL & 4 & ","
                ElseIf recKYOTAKURYOYO("o020") < 10 And recKYOTAKURYOYO("o020") <> 0 Then
                    strSQL = strSQL & 5 & ","
                Else
                    strSQL = strSQL & recKYOTAKURYOYO("o020") & ","
                End If
            End If
            '�F�m�Ǎ���ғ��퐶�������x�̃f�[�^���ڍs
            'NULL�̎��A�uNULL�v�������ڍs
            If IsNull(recKYOTAKURYOYO("o030")) Then
                strSQL = strSQL & "NULL" & ","
            Else
                '�F�m�Ǎ���ғ��퐶�������x�̃f�[�^���ڍs
                If recKYOTAKURYOYO("o030") = 3 Or recKYOTAKURYOYO("o030") = 4 Then
                    strSQL = strSQL & 3 & ","
                ElseIf recKYOTAKURYOYO("o030") = 5 Or recKYOTAKURYOYO("o030") = 6 Then
                    strSQL = strSQL & 4 & ","
                ElseIf recKYOTAKURYOYO("o030") = 7 Then
                    strSQL = strSQL & 5 & ","
                ElseIf recKYOTAKURYOYO("o030") = 8 Then
                    strSQL = strSQL & 6 & ","
                Else
                    strSQL = strSQL & recKYOTAKURYOYO("o030") & ","
                End If
            End If
            '�ݑ�×{�����̃|�C���g�̍쐬�N�����̃f�[�^���ڍs
            strSQL = strSQL & "'" & recKYOTAKURYOYO("d00") & "',"
            '�����̖K����̃f�[�^�̗L�����`�F�b�N
            If InStr(recKYOTAKURYOYO("t19"), ",") <> 0 Then
                '�擾�����f�[�^���J���}�ŕ�������
                varThisMonth = Split(recKYOTAKURYOYO("t19"), ",")
                '�J���}�ŕ��������f�[�^��0�ȏ�̎��A�������s��
                If UBound(varThisMonth) >= 0 Then
                    'NULL�̎��A�uNULL�v�������ڍs
                    If IsNull(varThisMonth(0)) Then
                        strSQL = strSQL & "NULL" & ","
                    Else
                        '�쐬�N��������N�����擾���A�擾�����f�[�^����Ƃ��A���t�^�Ńt�H�[�}�b�g��
                        '����ɁA�t�H�[�}�b�g�����f�[�^�̓��t�ɖ��������������`�F�b�N����
                        If IsDate(Format(Format(recKYOTAKURYOYO("d00"), "yyyy/mm") & "/" & varThisMonth(0), "yyyy/mm/dd")) Then
                            '������������΁A�t�H�[�}�b�g�������t���ڍs����
                            strSQL = strSQL & "'" & Format(Format(recKYOTAKURYOYO("d00"), "yyyy/mm") & "/" & varThisMonth(0), "yyyy/mm/dd") & "',"
                        Else
                            '����������΁A�uNULL�v�������ڍs����
                            strSQL = strSQL & "NULL" & ","
                        End If
                    End If
                Else
                    '�J���}�ŕ��������f�[�^��0�ȉ��̎��́A�uNULL�v�������ڍs����
                    strSQL = strSQL & "NULL" & ","
                End If
                '�ȍ~��L�Ɠ���������5�񑱂���
                '�J���}�ŕ��������f�[�^��1�ȏ�̎��A�������s��
                If UBound(varThisMonth) >= 1 Then
                    If IsNull(varThisMonth(1)) Then
                        strSQL = strSQL & "NULL" & ","
                    Else
                        If IsDate(Format(Format(recKYOTAKURYOYO("d00"), "yyyy/mm") & "/" & varThisMonth(1), "yyyy/mm/dd")) Then
                            strSQL = strSQL & "'" & Format(Format(recKYOTAKURYOYO("d00"), "yyyy/mm") & "/" & varThisMonth(1), "yyyy/mm/dd") & "',"
                        Else
                            strSQL = strSQL & "NULL" & ","
                        End If
                    End If
                Else
                    strSQL = strSQL & "NULL" & ","
                End If
                '�J���}�ŕ��������f�[�^��2�ȏ�̎��A�������s��
                If UBound(varThisMonth) >= 2 Then
                    If IsNull(varThisMonth(2)) Then
                        strSQL = strSQL & "NULL" & ","
                    Else
                        If IsDate(Format(Format(recKYOTAKURYOYO("d00"), "yyyy/mm") & "/" & varThisMonth(2), "yyyy/mm/dd")) Then
                            strSQL = strSQL & "'" & Format(Format(recKYOTAKURYOYO("d00"), "yyyy/mm") & "/" & varThisMonth(2), "yyyy/mm/dd") & "',"
                        Else
                            strSQL = strSQL & "NULL" & ","
                        End If
                    End If
                Else
                    strSQL = strSQL & "NULL" & ","
                End If
                '�J���}�ŕ��������f�[�^��3�ȏ�̎��A�������s��
                If UBound(varThisMonth) >= 3 Then
                    If IsNull(varThisMonth(3)) Then
                        strSQL = strSQL & "NULL" & ","
                    Else
                        If IsDate(Format(Format(recKYOTAKURYOYO("d00"), "yyyy/mm") & "/" & varThisMonth(3), "yyyy/mm/dd")) Then
                            strSQL = strSQL & "'" & Format(Format(recKYOTAKURYOYO("d00"), "yyyy/mm") & "/" & varThisMonth(3), "yyyy/mm/dd") & "',"
                        Else
                            strSQL = strSQL & "NULL" & ","
                        End If
                    End If
                Else
                    strSQL = strSQL & "NULL" & ","
                End If
                '�J���}�ŕ��������f�[�^��4�ȏ�̎��A�������s��
                If UBound(varThisMonth) >= 4 Then
                    If IsNull(varThisMonth(4)) Then
                        strSQL = strSQL & "NULL" & ","
                    Else
                        If IsDate(Format(Format(recKYOTAKURYOYO("d00"), "yyyy/mm") & "/" & varThisMonth(4), "yyyy/mm/dd")) Then
                            strSQL = strSQL & "'" & Format(Format(recKYOTAKURYOYO("d00"), "yyyy/mm") & "/" & varThisMonth(4), "yyyy/mm/dd") & "',"
                        Else
                            strSQL = strSQL & "NULL" & ","
                        End If
                    End If
                Else
                    strSQL = strSQL & "NULL" & ","
                End If
                '�J���}�ŕ��������f�[�^��5�ȏ�̎��A�������s��
                If UBound(varThisMonth) >= 5 Then
                    If IsNull(varThisMonth(5)) Then
                        strSQL = strSQL & "NULL" & ","
                    Else
                        If IsDate(Format(Format(recKYOTAKURYOYO("d00"), "yyyy/mm") & "/" & varThisMonth(5), "yyyy/mm/dd")) Then
                            strSQL = strSQL & "'" & Format(Format(recKYOTAKURYOYO("d00"), "yyyy/mm") & "/" & varThisMonth(5), "yyyy/mm/dd") & "',"
                        Else
                            strSQL = strSQL & "NULL" & ","
                        End If
                    End If
                Else
                    strSQL = strSQL & "NULL" & ","
                End If
            Else
                '�����̖K����̃f�[�^��NULL�̎��́A6��uNULL�v�������ڍs����
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
            End If
            '�����̖K����̃f�[�^�̗L�����`�F�b�N
            If InStr(recKYOTAKURYOYO("t01"), ",") <> 0 Then
                '�擾�����f�[�^���J���}�ŕ�������
                varNextMonth = Split(recKYOTAKURYOYO("t01"), ",")
                '�J���}�ŕ��������f�[�^��0�ȏ�̎��A�������s��
                If UBound(varNextMonth) >= 0 Then
                    'NULL�̎��A�uNULL�v�������ڍs
                    If IsNull(varNextMonth(0)) Then
                        strSQL = strSQL & "NULL" & ","
                    Else
                        '�쐬�N��������N�����擾��DateAdd�ɂ�莟���̔N���ɕϊ����A�擾�����f�[�^����Ƃ��A���t�^�Ńt�H�[�}�b�g��
                        '����ɁA�t�H�[�}�b�g�����f�[�^�̓��t�ɖ��������������`�F�b�N����
                        If IsDate(Format(Format(DateAdd("m", 1, recKYOTAKURYOYO("d00")), "yyyy/mm") & "/" & varNextMonth(0), "yyyy/mm/dd")) Then
                            '������������΁A�t�H�[�}�b�g�������t���ڍs����
                            strSQL = strSQL & "'" & Format(Format(DateAdd("m", 1, recKYOTAKURYOYO("d00")), "yyyy/mm") & "/" & varNextMonth(0), "yyyy/mm/dd") & "',"
                        Else
                             '����������΁A�uNULL�v�������ڍs����
                            strSQL = strSQL & "NULL" & ","
                        End If
                    End If
                Else
                    '�J���}�ŕ��������f�[�^��0�ȉ��̎��́A�uNULL�v�������ڍs����
                    strSQL = strSQL & "NULL" & ","
                End If
                '�ȍ~��L�Ɠ���������5�񑱂���
                '�J���}�ŕ��������f�[�^��1�ȏ�̎��A�������s��
                If UBound(varNextMonth) >= 1 Then
                    If IsNull(varNextMonth(1)) Then
                        strSQL = strSQL & "NULL" & ","
                    Else
                        If IsDate(Format(Format(DateAdd("m", 1, recKYOTAKURYOYO("d00")), "yyyy/mm") & "/" & varNextMonth(1), "yyyy/mm/dd")) Then
                            strSQL = strSQL & "'" & Format(Format(DateAdd("m", 1, recKYOTAKURYOYO("d00")), "yyyy/mm") & "/" & varNextMonth(1), "yyyy/mm/dd") & "',"
                        Else
                            strSQL = strSQL & "NULL" & ","
                        End If
                    End If
                Else
                    strSQL = strSQL & "NULL" & ","
                End If
                '�J���}�ŕ��������f�[�^��2�ȏ�̎��A�������s��
                If UBound(varNextMonth) >= 2 Then
                    If IsNull(varNextMonth(2)) Then
                        strSQL = strSQL & "NULL" & ","
                    Else
                        If IsDate(Format(Format(DateAdd("m", 1, recKYOTAKURYOYO("d00")), "yyyy/mm") & "/" & varNextMonth(2), "yyyy/mm/dd")) Then
                            strSQL = strSQL & "'" & Format(Format(DateAdd("m", 1, recKYOTAKURYOYO("d00")), "yyyy/mm") & "/" & varNextMonth(2), "yyyy/mm/dd") & "',"
                        Else
                            strSQL = strSQL & "NULL" & ","
                        End If
                    End If
                Else
                    strSQL = strSQL & "NULL" & ","
                End If
                '�J���}�ŕ��������f�[�^��3�ȏ�̎��A�������s��
                If UBound(varNextMonth) >= 3 Then
                    If IsNull(varNextMonth(3)) Then
                        strSQL = strSQL & "NULL" & ","
                    Else
                        If IsDate(Format(Format(DateAdd("m", 1, recKYOTAKURYOYO("d00")), "yyyy/mm") & "/" & varNextMonth(3), "yyyy/mm/dd")) Then
                            strSQL = strSQL & "'" & Format(Format(DateAdd("m", 1, recKYOTAKURYOYO("d00")), "yyyy/mm") & "/" & varNextMonth(3), "yyyy/mm/dd") & "',"
                        Else
                            strSQL = strSQL & "NULL" & ","
                        End If
                    End If
                Else
                    strSQL = strSQL & "NULL" & ","
                End If
                '�J���}�ŕ��������f�[�^��4�ȏ�̎��A�������s��
                If UBound(varNextMonth) >= 4 Then
                    If IsNull(varNextMonth(4)) Then
                        strSQL = strSQL & "NULL" & ","
                    Else
                        If IsDate(Format(Format(DateAdd("m", 1, recKYOTAKURYOYO("d00")), "yyyy/mm") & "/" & varNextMonth(4), "yyyy/mm/dd")) Then
                            strSQL = strSQL & "'" & Format(Format(DateAdd("m", 1, recKYOTAKURYOYO("d00")), "yyyy/mm") & "/" & varNextMonth(4), "yyyy/mm/dd") & "',"
                        Else
                            strSQL = strSQL & "NULL" & ","
                        End If
                    End If
                Else
                    strSQL = strSQL & "NULL" & ","
                End If
                '�J���}�ŕ��������f�[�^��5�ȏ�̎��A�������s��
                If UBound(varNextMonth) >= 5 Then
                    If IsNull(varNextMonth(5)) Then
                        strSQL = strSQL & "NULL" & ","
                    Else
                        If IsDate(Format(Format(DateAdd("m", 1, recKYOTAKURYOYO("d00")), "yyyy/mm") & "/" & varNextMonth(5), "yyyy/mm/dd")) Then
                            strSQL = strSQL & "'" & Format(Format(DateAdd("m", 1, recKYOTAKURYOYO("d00")), "yyyy/mm") & "/" & varNextMonth(5), "yyyy/mm/dd") & "',"
                        Else
                            strSQL = strSQL & "NULL" & ","
                        End If
                    End If
                Else
                    strSQL = strSQL & "NULL" & ","
                End If
            Else
                '�����̖K����̃f�[�^��NULL�̎��́A6��uNULL�v�������ڍs����
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
            End If
            '�i�j���̃A�h�o�C�X�̃f�[�^�̈ڍs
            'NULL�̎��́A�u0�v���ڍs
            If IsNull(recKYOTAKURYOYO("n01")) Then
                strSQL = strSQL & "0,"
            Else
                '�i�j���̃A�h�o�C�X�̃f�[�^���ڍs
                strSQL = strSQL & recKYOTAKURYOYO("n01") & ","
            End If
            '�A�h�o�C�X�̃f�[�^�̈ڍs
            If IsNull(recKYOTAKURYOYO("t02")) Then
                strSQL = strSQL & "'',"
            Else
                '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
                strSQL = strSQL & "'" & Replace(Left(recKYOTAKURYOYO("t02"), 1000), "'", "''") & "',"
            End If
            '��Ë@�֖��̃f�[�^�̈ڍs
            'NULL�̂Ƃ�
            If IsNull(recKYOTAKURYOYO("t03")) Then
                strSQL = strSQL & "'',"
            Else
                '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
                strSQL = strSQL & "'" & Replace(Left(recKYOTAKURYOYO("t03"), 64), "'", "''") & "',"
            End If
            '�S����t���̃f�[�^�̈ڍs
            'NULL�̂Ƃ�
            If IsNull(recKYOTAKURYOYO("t04")) Then
                strSQL = strSQL & "'',"
            Else
                '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
                strSQL = strSQL & "'" & Replace(Left(recKYOTAKURYOYO("t04"), 32), "'", "''") & "',"
            End If
            '�A����̃f�[�^�̈ڍs
            'strSQL = strSQL & "'" & recKYOTAKURYOYO("t05") & "',"
            '���x�������̃f�[�^�̈ڍs
            'NULL�̂Ƃ�
            If IsNull(recKYOTAKURYOYO("t06")) Then
                strSQL = strSQL & "'',"
            Else
                strSQL = strSQL & "'" & Replace(recKYOTAKURYOYO("t06"), "'", "''") & "',"
            End If
            '���Ə����̃f�[�^�̈ڍs
            'NULL�̂Ƃ�
            If IsNull(recKYOTAKURYOYO("t07")) Then
                strSQL = strSQL & "'',"
            Else
                strSQL = strSQL & "'" & Replace(Left(recKYOTAKURYOYO("t07"), 64), "'", "''") & "',"
            End If
            '����×{�Ǘ��w�����̃f�[�^�̈ڍs
            'NULL�̎��A�uNULL�v�������ڍs
            If IsNull(recKYOTAKURYOYO("d01")) Then
                strSQL = strSQL & "NULL" & ","
            Else
                '����×{�Ǘ��w�����̃f�[�^�̈ڍs
                strSQL = strSQL & "'" & recKYOTAKURYOYO("d01") & "',"
            End If
'            '�a��̕ω��^���ڂ̃f�[�^�̈ڍs
'            'NULL�̎��A�u0�v���ڍs
'            If IsNull(recKYOTAKURYOYO("o040")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '�a��̕ω��^���ڂ̃f�[�^�̈ڍs
'                strSQL = strSQL & recKYOTAKURYOYO("o040") & ","
'            End If
'            '�a��̕ω��^�ڍׂ̃f�[�^���ڍs
'            'NULL�̎��A�u0�v���ڍs
'            If IsNull(recKYOTAKURYOYO("o050")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '�a��̕ω��^�ڍׂ̃f�[�^���ڍs
'                strSQL = strSQL & recKYOTAKURYOYO("o050") & ","
'            End If
'            '�a��̕ω��^���̑����ӎ����̃f�[�^���ڍs
'            strSQL = strSQL & "'" & Left(recKYOTAKURYOYO("t10"), 100) & "',"
'            '���_�̏�ԁ^���ڂ̃f�[�^���ڍs
'            'NULL�̎��A�u0�v���ڍs
'            If IsNull(recKYOTAKURYOYO("o090")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '���_�̏�ԁ^���ڂ̃f�[�^���ڍs
'                strSQL = strSQL & recKYOTAKURYOYO("o090") & ","
'            End If
'            '���_�̏�ԁ^�ڍׁi���j�̃f�[�^�̈ڍs
'            strSQL = strSQL & "'" & recKYOTAKURYOYO("t13") & "',"
'            '���_�̏�ԁ^���̑����ӎ����̃f�[�^�̈ڍs
'            strSQL = strSQL & "'" & Left(recKYOTAKURYOYO("t14"), 100) & "',"
'            '�ړ��^���ڂ̃f�[�^�ڍs
'            'NULL�̎��A�u0�v���ڍs
'            If IsNull(recKYOTAKURYOYO("o060")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '�ړ��^���ڂ̃f�[�^�ڍs
'                strSQL = strSQL & recKYOTAKURYOYO("o060") & ","
'            End If
'            '�ړ��^���̑����ӎ����̃f�[�^�̈ڍs
'            strSQL = strSQL & "'" & Left(recKYOTAKURYOYO("t11"), 100) & "',"
'            '�ېH�^���ڂ̃f�[�^�ڍs
'            'NULL�̎��A�u0�v���ڍs
'            If IsNull(recKYOTAKURYOYO("o100")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '�ېH�^���ڂ̃f�[�^�ڍs
'                strSQL = strSQL & recKYOTAKURYOYO("o100") & ","
'            End If
'            '�ېH�^�ڍׂ̃f�[�^�̈ڍs
'            'NULL�̎��A�u0�v���ڍs
'            If IsNull(recKYOTAKURYOYO("o110")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '�ېH�^�ڍׂ̃f�[�^�̈ڍs
'                strSQL = strSQL & recKYOTAKURYOYO("o110") & ","
'            End If
'            '�ېH�^���̑��̗��ӎ����̃f�[�^�̈ڍs
'            strSQL = strSQL & "'" & Left(recKYOTAKURYOYO("t15"), 100) & "',"
'            '�����^���ڂ̃f�[�^�̈ڍs
'            'NULL�̎��A�u0�v���ڍs
'            If IsNull(recKYOTAKURYOYO("o070")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '�����^���ڂ̃f�[�^�̈ڍs
'                strSQL = strSQL & recKYOTAKURYOYO("o070") & ","
'            End If
'            '�����^�ڍׂ̃f�[�^�̈ڍs
'            'NULL�̎��A�u0�v���ڍs
'            If IsNull(recKYOTAKURYOYO("o080")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '�����^�ڍׂ̃f�[�^�̈ڍs
'                strSQL = strSQL & recKYOTAKURYOYO("o080") & ","
'            End If
'            '�����^���̑����ӎ����̃f�[�^�̈ڍs
'            strSQL = strSQL & "'" & Left(recKYOTAKURYOYO("t12"), 100) & "',"
'            '���̑����ӓ_�^�����E���A�a�E���M�̃f�[�^�̈ڍs
'            'NULL�̎��A�u0�v���ڍs
'            If IsNull(recKYOTAKURYOYO("c10")) Then
'                strSQL = strSQL & "0,"
'                strSQL = strSQL & "0,"
'                strSQL = strSQL & "0,"
'            Else
'                '���̑����ӓ_�^�����E���A�a�E���M�̃f�[�^�̈ڍs
'                strSQL = strSQL & Left(recKYOTAKURYOYO("c10"), 1) & ","
'                strSQL = strSQL & Mid(recKYOTAKURYOYO("c10"), 2, 1) & ","
'                strSQL = strSQL & Right(recKYOTAKURYOYO("c10"), 1) & ","
'            End If
'            '���̑����ӓ_�^�ڍׁi����H�j�̃f�[�^���ڍs
'            'NULL�̎��A�u0�v���ڍs
'            If IsNull(recKYOTAKURYOYO("n02")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '���̑����ӓ_�^�ڍׁi����H�j�̃f�[�^���ڍs
'                strSQL = strSQL & recKYOTAKURYOYO("n02") & ","
'            End If
'            '���̑����ӓ_�^�ڍׁi����L�j�̃f�[�^���ڍs
'            'NULL�̎��A�u0�v���ڍs
'            If IsNull(recKYOTAKURYOYO("n03")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '���̑����ӓ_�^�ڍׁi����L�j�̃f�[�^���ڍs
'                strSQL = strSQL & recKYOTAKURYOYO("n03") & ","
'            End If
'            '���̑����ӓ_�^�ڍׁi�̉��j�̃f�[�^���ڍs
'            strSQL = strSQL & "'" & recKYOTAKURYOYO("n04") & "',"
'            '���̑����ӓ_�^���̑����ӓ_�̃f�[�^���ڍs
'            strSQL = strSQL & "'" & Left(recKYOTAKURYOYO("t16"), 100) & "',"
'            '�莞�������e�̃f�[�^�̈ڍs
'            strSQL = strSQL & "'" & Left(recKYOTAKURYOYO("t17"), 255) & "',"
'            '���p�҂ւ̎w�����e�̃f�[�^�̈ڍs
'            strSQL = strSQL & "'" & Left(recKYOTAKURYOYO("t18"), 255) & "',"
            '�ŏI�X�V���ɃV�X�e�����t��o�^
            strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
            strSQL = strSQL & ")"
            Call FDBExecuteSQL(strSQL)
        End If
        recKYOTAKURYOYO.MoveNext
    Loop
    
    Exit Sub

Err_Connection:

    MsgBox "�f�[�^�̈ڍs�Ɏ��s���܂����B" & vbNewLine & "�\���󂠂�܂��񂪁A�f�[�^�̈ڍs���͂��߂����蒼���Ă��������B" _
    , vbInformation + vbOKOnly, "�f�[�^�ڍs���s"
    
    End

End Sub

Public Sub ConvINSURER()
'============================================================================================
'�ی��ҏ��ڍs�i�S���ʁj
'============================================================================================
Dim recINSURER As Object
Dim strSQL As String
Dim varTel As Variant

    '�G���[����
    On Error GoTo Err_Connection

    '�ی��ҏ��e�[�u���̎擾
    Set recINSURER = MDBExecuteRecordSet("SELECT * FROM m_insr", adOpenForwardOnly, adLockReadOnly)
    
    '�ی��ҏ�񐔕���������
    Do Until recINSURER.EOF
        
        '�d�b�ԍ����n�C�t���ŕ���
        If InStr(recINSURER("insr_tel"), "-") <> 0 Then
            '�擾�����f�[�^�𔼊p�ɕύX
            varTel = Split(StrConv(recINSURER("insr_tel"), vbNarrow), "-")
        Else
            varTel = recINSURER("insr_tel")
        End If
        
        '�ی��ҏ��e�[�u�����ڍs
        strSQL = ""
        strSQL = strSQL & "INSERT INTO INSURER ("
        strSQL = strSQL & "INSURER_ID,"
        strSQL = strSQL & "INSURER_NAME,"
        strSQL = strSQL & "INSURER_ZIP_FIRST,"
        strSQL = strSQL & "INSURER_ZIP_SECOND,"
        strSQL = strSQL & "INSURER_ADDRESS,"
        strSQL = strSQL & "INSURER_TEL_FIRST,"
        strSQL = strSQL & "INSURER_TEL_SECOND,"
        strSQL = strSQL & "INSURER_TEL_THIRD,"
        strSQL = strSQL & "DELETE_FLAG,"
        strSQL = strSQL & "LAST_TIME"
        strSQL = strSQL & ")"
        
        strSQL = strSQL & " VALUES ("
        '�ی��Ҕԍ��̃f�[�^���ڍs
        strSQL = strSQL & "'" & recINSURER("insr_no") & "',"
        '�ی��Җ��̃f�[�^���ڍs
        'NULL�̎��́A�󕶎����ڍs
        If IsNull(recINSURER("insr_nm")) Then
            strSQL = strSQL & "'',"
        '�V���O���N�H�[�g��u�����Ĉڍs����B
        Else
            strSQL = strSQL & "'" & Replace(recINSURER("insr_nm"), "'", "''") & "',"
        End If
        '�X�֔ԍ��̃f�[�^���ڍs
        'NULL�̎��́A�󕶎����ڍs
        If IsNull(recINSURER("insr_zip_code")) Then
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        '�X�֔ԍ��̃f�[�^�̒�����3�ȏ�̎�
        ElseIf Len(recINSURER("insr_zip_code")) > 3 Then
            '�X�֔ԍ��̃f�[�^�̍�����3�����ڍs
            strSQL = strSQL & "'" & Left$(recINSURER("insr_zip_code"), 3) & "',"
            '�X�֔ԍ��̃f�[�^��4���ڂ���f�[�^���ڍs
            strSQL = strSQL & "'" & Mid$(recINSURER("insr_zip_code"), 4, Len(recINSURER("insr_zip_code"))) & "',"
        '��L�ȊO�̎���
        Else
            '�X�֔ԍ��̃f�[�^��������f�[�^�̐����ڍs
            strSQL = strSQL & "'" & Left$(recINSURER("insr_zip_code"), Len(recINSURER("insr_zip_code"))) & "',"
            '��f�[�^���ڍs
            strSQL = strSQL & "'',"
        End If
        '�Z���̃f�[�^���ڍs
        strSQL = strSQL & "'" & recINSURER("insr_address") & "',"
        '�d�b�ԍ��̃f�[�^���ڍs
        'NULL�̎��A��f�[�^��3�ڍs
        If IsNull(recINSURER("insr_tel")) Then
                strSQL = strSQL & "'',"
                strSQL = strSQL & "'',"
                strSQL = strSQL & "'',"
        Else
            '�n�C�t���̋�؂肪���鎞�̃f�[�^�ڍs
            If InStr(recINSURER("insr_tel"), "-") <> 0 Then
                '���������f�[�^�����l�^���`�F�b�N����
                If IsNumeric(varTel(0)) = True Then
                    '������6���̃f�[�^���ڍs
                    strSQL = strSQL & "'" & Left$(varTel(0), 6) & "',"
                '���l�^�łȂ���
                Else
                    '��f�[�^���ڍs
                    strSQL = strSQL & "'',"
                End If
                '���������f�[�^�̌���0�ȏ�̎�
                If UBound(varTel) > 0 Then
                    '���������f�[�^�����l�^���`�F�b�N����
                    If IsNumeric(varTel(1)) = True Then
                        'NULL�łȂ����A������4���̃f�[�^���ڍs
                        If Not IsNull(varTel(1)) Then strSQL = strSQL & "'" & Left$(varTel(1), 4) & "',"
                    '���l�^�łȂ��Ƃ�
                    Else
                        '��f�[�^���ڍs
                        strSQL = strSQL & "'',"
                    End If
                '���������f�[�^�̌���0�ȉ�
                Else
                    '��f�[�^���ڍs
                    strSQL = strSQL & "'',"
                End If
                '���������f�[�^�̌���1�ȏ�̎�
                If UBound(varTel) > 1 Then
                    '���l�^�̃`�F�b�N
                    If IsNumeric(varTel(2)) = True Then
                        'NULL�̎��A������4���̃f�[�^���ڍs
                        If Not IsNull(varTel(2)) Then strSQL = strSQL & "'" & Left$(varTel(2), 4) & "',"
                    '���l�^�łȂ���
                    Else
                        '��f�[�^���ڍs
                        strSQL = strSQL & "'',"
                    End If
                '���������f�[�^��1�ȉ�
                Else
                    '��f�[�^���ڍs
                    strSQL = strSQL & "'',"
                End If
            '�n�C�t���̋�؂�̖����Ƃ�
            Else
                '���l�^�̃`�F�b�N
                If IsNumeric(varTel) = True Then
                    '������6���̃f�[�^���ڍs
                    strSQL = strSQL & "'" & Left$(varTel, 6) & "',"
                '���l�^�łȂ��Ƃ�
                Else
                    '��̃f�[�^���ڍs
                    strSQL = strSQL & "'',"
                End If
                '��̃f�[�^��2�ڍs
                strSQL = strSQL & "'',"
                strSQL = strSQL & "'',"
            End If
        End If
        '�폜�t���O�Ɂu0�v��o�^
        strSQL = strSQL & "0,"
        '�ŏI�X�V���ɃV�X�e�����t��o�^
        strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
        strSQL = strSQL & ")"
        
        Call FDBExecuteSQL(strSQL)
    
        recINSURER.MoveNext
    Loop
    
    Exit Sub
    
Err_Connection:

    MsgBox "�f�[�^�̈ڍs�Ɏ��s���܂����B" & vbNewLine & "�\���󂠂�܂��񂪁A�f�[�^�̈ڍs���͂��߂����蒼���Ă��������B" _
    , vbInformation + vbOKOnly, "�f�[�^�ڍs���s"
    
    End
    
End Sub

Public Sub ConvProviderInfo()
'==============================================================================================
'�Z�������E�{�݊֘A���
'==============================================================================================
Dim recProviderInfo As Object
Dim strSQL As String

    '�G���[����
    On Error GoTo Err_Connection

    '���p�ҏ��e�[�u���̎擾
    Set recProviderInfo = MDBExecuteRecordSet("SELECT * FROM m_insd", adOpenForwardOnly, adLockReadOnly)
    
    '���p�ҏ�񐔕���������
    Do Until recProviderInfo.EOF
    
        '�Z���E�{�݊֘A�����ڍs
        strSQL = ""
        strSQL = strSQL & "INSERT INTO PATIENT_SHISETSU_HISTORY ("
        strSQL = strSQL & "PATIENT_ID,"
        strSQL = strSQL & "SHISETSU_HISTORY_ID,"
        strSQL = strSQL & "TOKUTEI_NYUSHO_FLAG,"
        strSQL = strSQL & "LIMIT_SHOKUHI,"
        strSQL = strSQL & "LIMIT_UNIT_KOSHITSU,"
        strSQL = strSQL & "LIMIT_UNIT_JUNKOSHITSU,"
        strSQL = strSQL & "LIMIT_JURAIGATA1,"
        strSQL = strSQL & "LIMIT_JURAIGATA2,"
        strSQL = strSQL & "LIMIT_TASHOSHITSU,"
        strSQL = strSQL & "KYUSOCHI_FLAG,"
        strSQL = strSQL & "DISEASE,"
        strSQL = strSQL & "LAST_TIME"
        strSQL = strSQL & ")"
        
        strSQL = strSQL & " VALUES ("
        '���p��ID�̃f�[�^�ڍs
        strSQL = strSQL & recProviderInfo("pat_id") & ","
        '�{�ݗ���ԍ��Ɂu1�v���ڍs
        strSQL = strSQL & 1 & ","
        '��������҃t���O�̃f�[�^���ڍs
        'NULL�̎�
        If IsNull(recProviderInfo("sp59_flg")) Then
            '�u0�v���ڍs
            strSQL = strSQL & 0 & ","
        'NULL�ȊO�̂Ƃ�
        Else
            If recProviderInfo("sp59_flg") = True Then
                '�u2�v���ڍs
                strSQL = strSQL & 2 & ","
            Else
                '�u1�v���ڍs
                strSQL = strSQL & 1 & ","
            End If
        End If
        '�H��S���x�z�̃f�[�^���ڍs
        'NULL�̎�
        If IsNull(recProviderInfo("sp59_shokuhi")) Then
            '�u0�v���ڍs
            strSQL = strSQL & 0 & ","
        'NULL�ȊO�̂Ƃ�
        Else
            '�ڍs������f�[�^���ڍs
            strSQL = strSQL & recProviderInfo("sp59_shokuhi") & ","
        End If
        '���j�b�g�^�����S���x�z
        'NULL�̎�
        If IsNull(recProviderInfo("sp59_unit_koshitsu")) Then
            '�u0�v���ڍs
            strSQL = strSQL & 0 & ","
        'NULL�ȊO�̂Ƃ�
        Else
            '�ڍs������f�[�^���ڍs
            strSQL = strSQL & recProviderInfo("sp59_unit_koshitsu") & ","
        End If
        '���j�b�g�^�������S���x�z
        'NULL�̎�
        If IsNull(recProviderInfo("sp59_unit_junkoshitsu")) Then
            '�u0�v���ڍs
            strSQL = strSQL & 0 & ","
        'NULL�ȊO�̂Ƃ�
        Else
            '�ڍs������f�[�^���ڍs
            strSQL = strSQL & recProviderInfo("sp59_unit_junkoshitsu") & ","
        End If
        '�]���^��(���{)���S���x�z
        'NULL�̎�
        If IsNull(recProviderInfo("sp59_juurai_koshitsu_tokuyou")) Then
            '�u0�v���ڍs
            strSQL = strSQL & 0 & ","
        'NULL�ȊO�̂Ƃ�
        Else
            '�ڍs������f�[�^���ڍs
            strSQL = strSQL & recProviderInfo("sp59_juurai_koshitsu_tokuyou") & ","
        End If
        '�]���^��(�V����×{)���S���x�z
        'NULL�̎�
        If IsNull(recProviderInfo("sp59_juurai_koshitsu_rouken_ryouyou")) Then
            '�u0�v���ڍs
            strSQL = strSQL & 0 & ","
        'NULL�ȊO�̂Ƃ�
        Else
            '�ڍs������f�[�^���ڍs
            strSQL = strSQL & recProviderInfo("sp59_juurai_koshitsu_rouken_ryouyou") & ","
        End If
        '���������S���x�z
        'NULL�̎�
        If IsNull(recProviderInfo("sp59_tashoushitsu")) Then
            '�u0�v���ڍs
            strSQL = strSQL & 0 & ","
        'NULL�ȊO�̎�
        Else
            '�ڍs������f�[�^���ڍs
            strSQL = strSQL & recProviderInfo("sp59_tashoushitsu") & ","
        End If
        '���[�u�����ғ���t���O
        'NULL�̎�
        If IsNull(recProviderInfo("kyuu_sochi_nyuusho")) Then
            '�u0�v���ڍs
            strSQL = strSQL & 0 & ","
        'NULL�ȊO�̂Ƃ�
        Else
            '�ڍs������f�[�^���ڍs
            strSQL = strSQL & recProviderInfo("kyuu_sochi_nyuusho") & ","
        End If
        '�叝�a��
        If IsNull(recProviderInfo("main_disease")) Then
            '��̃f�[�^���ڍs
            strSQL = strSQL & "'',"
        'NULL�ȊO�̂Ƃ�
        Else
            '�ڍs������f�[�^���ڍs�i�V���O���N�H�[�g��u���j
            strSQL = strSQL & "'" & Replace(recProviderInfo("main_disease"), "'", "''") & "',"
        End If
        '�ŏI�X�V���ɃV�X�e�����t��o�^
        strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
        strSQL = strSQL & ")"
        
        Call FDBExecuteSQL(strSQL)
    
        recProviderInfo.MoveNext
    Loop
    
    Exit Sub
    
Err_Connection:

    MsgBox "�f�[�^�̈ڍs�Ɏ��s���܂����B" & vbNewLine & "�\���󂠂�܂��񂪁A�f�[�^�̈ڍs���͂��߂����蒼���Ă��������B" _
    , vbInformation + vbOKOnly, "�f�[�^�ڍs���s"
    
    End

End Sub

Public Sub ConvPATIENT()
'============================================================================================
'���p�ҏ��ڍs�i�S���ʁj
'============================================================================================
Dim recPATIENT As Object
Dim strSQL As String
Dim varName As Variant
Dim varKanaName As Variant
Dim varTel As Variant

    '�G���[����
    On Error GoTo Err_Connection

    '���p�ҏ��e�[�u���̎擾
    Set recPATIENT = MDBExecuteRecordSet("SELECT * FROM m_insd", adOpenForwardOnly, adLockReadOnly)
        
    '���p�ҏ�񐔕���������
    Do Until recPATIENT.EOF
        
        '�������X�y�[�X�ŕ���
        If InStr(recPATIENT("pat_nm"), " ") <> 0 Then
            varName = Split(recPATIENT("pat_nm"), " ")
        ElseIf InStr(recPATIENT("pat_nm"), "�@") <> 0 Then
            varName = Split(recPATIENT("pat_nm"), "�@")
        Else
            varName = recPATIENT("pat_nm")
        End If
        '���Ȏ������X�y�[�X�ŕ���
        If InStr(recPATIENT("pat_knm"), " ") <> 0 Then
            varKanaName = Split(recPATIENT("pat_knm"), " ")
        ElseIf InStr(recPATIENT("pat_knm"), "�@") <> 0 Then
            varKanaName = Split(recPATIENT("pat_knm"), "�@")
        Else
            varKanaName = recPATIENT("pat_knm")
        End If
        '�d�b�ԍ����n�C�t���ŕ���
        If InStr(recPATIENT("pat_tel"), "-") <> 0 Then
            varTel = Split(StrConv(recPATIENT("pat_tel"), vbNarrow), "-")
        Else
            varTel = recPATIENT("pat_tel")
        End If
        
        '���p�ҏ��e�[�u�����ڍs
        strSQL = ""
        strSQL = strSQL & "INSERT INTO PATIENT ("
        strSQL = strSQL & "PATIENT_ID,"
        strSQL = strSQL & "PATIENT_CODE,"
        strSQL = strSQL & "PATIENT_FAMILY_NAME,"
        strSQL = strSQL & "PATIENT_FIRST_NAME,"
        strSQL = strSQL & "PATIENT_FAMILY_KANA,"
        strSQL = strSQL & "PATIENT_FIRST_KANA,"
        strSQL = strSQL & "PATIENT_SEX,"
        strSQL = strSQL & "PATIENT_BIRTHDAY,"
        strSQL = strSQL & "PATIENT_TEL_FIRST,"
        strSQL = strSQL & "PATIENT_TEL_SECOND,"
        strSQL = strSQL & "PATIENT_TEL_THIRD,"
        strSQL = strSQL & "PATIENT_ZIP_FIRST,"
        strSQL = strSQL & "PATIENT_ZIP_SECOND,"
        strSQL = strSQL & "PATIENT_ADDRESS,"
        strSQL = strSQL & "SHOW_FLAG,"
        strSQL = strSQL & "DELETE_FLAG,"
        strSQL = strSQL & "LAST_TIME"
        strSQL = strSQL & ")"
        
        strSQL = strSQL & " VALUES ("
        '���p��ID�̃f�[�^�ڍs
        strSQL = strSQL & recPATIENT("pat_id") & ","
        '���p�ғ���ID���ڍs
        'NULL�̎�
        If IsNull(recPATIENT("pat_cd")) Then
            '��̃f�[�^���ڍs
            strSQL = strSQL & "'',"
        Else
            '�ڍs���f�[�^���ڍs�i�V���O���N�H�[�g��u���j
            strSQL = strSQL & "'" & Replace(recPATIENT("pat_cd"), "'", "''") & "',"
        End If
        '���p�Ҏ����̃f�[�^���ڍs
        '�X�y�[�X�ŕ��������f�[�^���A0�Ŗ������
        If InStr(recPATIENT("pat_nm"), " ") <> 0 Or InStr(recPATIENT("pat_nm"), "�@") <> 0 Then
            '���p�Ҏ����̃f�[�^���ڍs
            'NULL�̎�
            If IsNull(varName(0)) Then
                '��̃f�[�^���ڍs
                strSQL = strSQL & "'',"
            Else
                '���̃f�[�^���ڍs�i�V���O���N�H�[�g�j
                strSQL = strSQL & "'" & Replace(Left(varName(0), 16), "'", "''") & "',"
            End If
            'NULL�̎�
            If IsNull(varName(1)) Then
                '��̃f�[�^���ڍs
                strSQL = strSQL & "'',"
            Else
                '���̃f�[�^���ڍs�i�V���O���N�H�[�g�j
                strSQL = strSQL & "'" & Replace(Left(varName(1), 16), "'", "''") & "',"
            End If
        '�����f�[�^��0�Ȃ�
        Else
            '���p�Ҏ����̃f�[�^���ڍs
            'NULL�̎�
            If IsNull(varName) Then
                '��̃f�[�^���ڍs
                strSQL = strSQL & "'',"
            Else
                strSQL = strSQL & "'" & Replace(Left(varName, 16), "'", "''") & "',"
            End If
            '��̃f�[�^���ڍs
            strSQL = strSQL & "'',"
        End If
        '���p�҂��Ȏ����̃f�[�^���ڍs
        '�X�y�[�X�ŕ��������f�[�^���A0�Ŗ������
        If InStr(recPATIENT("pat_knm"), " ") <> 0 Or InStr(recPATIENT("pat_knm"), "�@") <> 0 Then
            '���p�҂��Ȏ�����S�p�Ђ炪�Ȃɕϊ����A�f�[�^���ڍs
            'NULL�̎�
            If IsNull(varKanaName(0)) Then
                '��̃f�[�^���ڍs
                strSQL = strSQL & "'',"
            Else
                '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
                strSQL = strSQL & "'" & Replace(Left(StrConv(StrConv(varKanaName(0), vbWide), vbHiragana), 16), "'", "''") & "',"
            End If
            'NULL�̎�
            If IsNull(varKanaName(1)) Then
                '��̃f�[�^���ڍs
                strSQL = strSQL & "'',"
            Else
                '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
                strSQL = strSQL & "'" & Replace(Left(StrConv(StrConv(varKanaName(1), vbWide), vbHiragana), 16), "'", "''") & "',"
            End If
        Else
            '���p�҂��Ȏ�����S�p�Ђ炪�Ȃɕϊ����A�f�[�^���ڍs
            'NULL�̎�
            If IsNull(varKanaName) Then
                '��̃f�[�^���ڍs
                strSQL = strSQL & "'',"
            Else
            
                strSQL = strSQL & "'" & Replace(Left(StrConv(StrConv(varKanaName, vbWide), vbHiragana), 16), "'", "''") & "',"
            End If
            '��̃f�[�^���ڍs
            strSQL = strSQL & "'',"
        End If
        '���ʂ̃f�[�^���ڍs
        'NULL�Ŗ�����
        If Not IsNull(recPATIENT("pat_sex")) Then
            '���ʂ̃f�[�^���ڍs
            strSQL = strSQL & recPATIENT("pat_sex") & ","
        'NULL�̎�
        Else
            '�u0�v���ڍs
            strSQL = strSQL & "0,"
        End If
        '���N�����̃f�[�^���ڍs
        'NULL�̎�
        If IsNull(recPATIENT("pat_birthday")) Then
            '�uNULL�v�������ڍs
            strSQL = strSQL & "NULL" & ","
        'NULL�ȊO
        Else
            '�F����̃f�[�^���ڍs
            strSQL = strSQL & "'" & recPATIENT("pat_birthday") & "',"
        End If
        '�d�b�ԍ��̃f�[�^���ڍs
        'NULL�̎�
        If IsNull(recPATIENT("pat_tel")) Then
            '��f�[�^��3�ڍs
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        'NULL�łȂ��A�n�C�t���ŕ��������f�[�^��0�ȏ�̎�
        ElseIf InStr(recPATIENT("pat_tel"), "-") <> 0 Then
            '���l�^�̎�
            If IsNumeric(varTel(0)) = True Then
                '������6���̃f�[�^���ڍs
                strSQL = strSQL & "'" & Left$(varTel(0), 6) & "',"
            '���l�^�łȂ���
            Else
                '��̃f�[�^���ڍs
                strSQL = strSQL & "'',"
            End If
            '���������f�[�^��0�ȏ�̎�
            If UBound(varTel) > 0 Then
                '���l�^�̎�
                If IsNumeric(varTel(1)) = True Then
                    'NULL�Ŗ������A������4�����f�[�^�ڍs
                    If Not IsNull(varTel(1)) Then strSQL = strSQL & "'" & Left$(varTel(1), 4) & "',"
                '���l�^�łȂ��Ƃ�
                Else
                    '��̃f�[�^���ڍs
                    strSQL = strSQL & "'',"
                End If
            '���������f�[�^��0�̎�
            Else
                '��f�[�^���ڍs
                strSQL = strSQL & "'',"
            End If
            '���������f�[�^��1�ȏ�̎�
            If UBound(varTel) > 1 Then
                '���l�^�łȂ��Ƃ�
                If IsNumeric(varTel(2)) = True Then
                    'NULL�łȂ����A������4�����f�[�^�ڍs
                    If Not IsNull(varTel(2)) Then strSQL = strSQL & "'" & Left$(varTel(2), 4) & "',"
                '���l�^�łȂ��Ƃ�
                Else
                    '��f�[�^�łȂ��Ƃ�
                    strSQL = strSQL & "'',"
                End If
            '���������f�[�^��0�̂Ƃ�
            Else
                '��f�[�^���ڍs
                strSQL = strSQL & "'',"
            End If
        'NULL�łȂ��A�n�C�t���ŕ��������f�[�^��0�̎�
        Else
            '���l�^�̂Ƃ�
            If IsNumeric(varTel) = True Then
                '������6���̃f�[�^���ڍs
                strSQL = strSQL & "'" & Left$(varTel, 6) & "',"
            '���l�^�łȂ���
            Else
                '��̃f�[�^���ڍs
                strSQL = strSQL & "'',"
            End If
            '��̃f�[�^��2�ڍs
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        End If
        '�X�֔ԍ��̃f�[�^���ڍs
        'NULL�̎�
        If IsNull(recPATIENT("pat_zip_code")) Then
            '��̃f�[�^��2�ڍs
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        '�X�֔ԍ��̃f�[�^�̒�����3�ȏ�̎�
        ElseIf Len(recPATIENT("pat_zip_code")) > 3 Then
            '������3���̃f�[�^���ڍs
            strSQL = strSQL & "'" & Left$(recPATIENT("pat_zip_code"), 3) & "',"
            '4������f�[�^�̍ŏI�܂ł̃f�[�^���ڍs
            strSQL = strSQL & "'" & Mid$(recPATIENT("pat_zip_code"), 4, Len(recPATIENT("pat_zip_code"))) & "',"
        '�f�[�^�̒�����3�ȉ��̎�
        Else
            '������3���̃f�[�^���ڍs
            strSQL = strSQL & "'" & Left$(recPATIENT("pat_zip_code"), 3) & "',"
            '��̃f�[�^���ڍs
            strSQL = strSQL & "'',"
        End If
        '�Z���̃f�[�^���ڍs
        If IsNull(recPATIENT("pat_address")) Then
            '��̃f�[�^���ڍs
            strSQL = strSQL & "'',"
        Else
            '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
            strSQL = strSQL & "'" & Replace(recPATIENT("pat_address"), "'", "''") & "',"
        End If
        '�\���t���O�̃f�[�^���ڍs
        'NULL�̎�
        If IsNull(recPATIENT("hidden_pat")) Then
            '�u0�v���ڍs
            strSQL = strSQL & "0,"
        'NULL�łȂ���
        Else
            '�\���t���O�̃f�[�^���ڍs
            strSQL = strSQL & recPATIENT("hidden_pat") & ","
        End If
        '�폜�t���O�Ɂu0�v��o�^
        strSQL = strSQL & "0,"
        '�ŏI�X�V���ɃV�X�e�����t��o�^
        strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
        strSQL = strSQL & ")"
        
        Call FDBExecuteSQL(strSQL)
    
        '============================================================================================
        '�F�藚�����ڍs�i�S���ʁj
        '============================================================================================
        Dim recNINTEIRIREKI As Object
        Dim recNINTEIRIREKI_COUNT As Object
        Dim strNinteiSQL As String


            '�F�藚�����e�[�u�����痚�����擾
            Set recNINTEIRIREKI_COUNT = MDBExecuteRecordSet("SELECT * FROM m_nurs_stat_hist WHERE " & _
            "pat_id=" & recPATIENT("pat_id") & " ORDER BY id DESC", adOpenForwardOnly, adLockReadOnly)
            
            '�F�藚�����e�[�u������L�����ԍő�̃f�[�^���擾
            Set recNINTEIRIREKI = MDBExecuteRecordSet("SELECT * FROM m_nurs_stat_hist WHERE pat_id = " & recPATIENT("pat_id") & " AND " & _
            "valid_from=(select MAX(valid_from) from m_nurs_stat_hist WHERE pat_id=" & recPATIENT("pat_id") & ")", _
            adOpenForwardOnly, adLockReadOnly)


            '�F�藚�����̗L�����Ԃ���Ŗ�����
            If Not recNINTEIRIREKI.EOF Then
                                    
                '�F�藚�����e�[�u�����ڍs
                strNinteiSQL = ""
                strNinteiSQL = strNinteiSQL & "INSERT INTO PATIENT_NINTEI_HISTORY ("
                strNinteiSQL = strNinteiSQL & "PATIENT_ID,"
                strNinteiSQL = strNinteiSQL & "NINTEI_HISTORY_ID,"
                strNinteiSQL = strNinteiSQL & "INSURER_ID,"
                strNinteiSQL = strNinteiSQL & "INSURED_ID,"
                strNinteiSQL = strNinteiSQL & "INSURE_RATE,"
                strNinteiSQL = strNinteiSQL & "PLANNER,"
                strNinteiSQL = strNinteiSQL & "PROVIDER_ID,"
                strNinteiSQL = strNinteiSQL & "SHUBETSU_CODE,"
                strNinteiSQL = strNinteiSQL & "CHANGE_CODE,"
                strNinteiSQL = strNinteiSQL & "JOTAI_CODE,"
                strNinteiSQL = strNinteiSQL & "SHINSEI_DATE,"
                strNinteiSQL = strNinteiSQL & "NINTEI_DATE,"
                strNinteiSQL = strNinteiSQL & "INSURE_VALID_START,"
                strNinteiSQL = strNinteiSQL & "INSURE_VALID_END,"
                strNinteiSQL = strNinteiSQL & "STOP_DATE,"
                strNinteiSQL = strNinteiSQL & "STOP_REASON,"
                strNinteiSQL = strNinteiSQL & "REPORTED_DATE,"
                strNinteiSQL = strNinteiSQL & "LIMIT_RATE,"
                strNinteiSQL = strNinteiSQL & "EXTERNAL_USE_LIMIT,"
                strNinteiSQL = strNinteiSQL & "LAST_TIME"
                strNinteiSQL = strNinteiSQL & ")"
                
                strNinteiSQL = strNinteiSQL & " VALUES ("
                '���p�Ҕԍ��̃f�[�^���ڍs
                strNinteiSQL = strNinteiSQL & recPATIENT("pat_id") & ","
                '�F�藚��ԍ��Ɂu1�v��o�^
                strNinteiSQL = strNinteiSQL & "'" & 1 & "',"
                '�ی��Ҕԍ��̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recPATIENT("insr_no")) Then
                    '��̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "'',"
                Else
                    '�ڍs���f�[�^�̈ڍs�i�V���O���N�H�[�g��u���j
                    strNinteiSQL = strNinteiSQL & "'" & Replace(recPATIENT("insr_no"), "'", "''") & "',"
                End If
                '��ی��Ҕԍ��̃f�[�^�ڍs
                If IsNull(recPATIENT("insd_no")) Then
                    '��̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "'',"
                Else
                    '�ڍs���f�[�^�̈ڍs�i�V���O���N�H�[�g��u���j
                    strNinteiSQL = strNinteiSQL & "'" & Replace(recPATIENT("insd_no"), "'", "''") & "',"
                End If
                '���t���̃f�[�^���ڍs
                strNinteiSQL = strNinteiSQL & recPATIENT("ins_rate") & ","
                '����v��쐬�҂̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recPATIENT("planner")) Then
                    '�u0�v���ڍs
                    strNinteiSQL = strNinteiSQL & "0,"
                'NULL�łȂ���
                Else
                    '����v��쐬�҂̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & recPATIENT("planner") & ","
                End If
                '����T�[�r�X�쐬���Ə��ԍ��̃f�[�^���ڍs
                strNinteiSQL = strNinteiSQL & "'" & recPATIENT("planner_no") & "',"
                '�\����ʃR�[�h�̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI("apply_type")) Then
                    '�u0�v���ڍs
                    strNinteiSQL = strNinteiSQL & "0,"
                'NULL�łȂ���
                Else
                    '�\����ʃR�[�h�̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & recNINTEIRIREKI("apply_type") & ","
                End If
                '�\�����R�[�h�̃f�[�^�ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI("change_apply")) Then
                    '�u0�v���ڍs
                    strNinteiSQL = strNinteiSQL & "0,"
                'NULL�łȂ���
                Else
                    '�ڍs���f�[�^���u2�v��
                    If recNINTEIRIREKI("change_apply") = 2 Then
                        '�u1�v���ڍs
                        strNinteiSQL = strNinteiSQL & "1,"
                    '�u2�v�ȊO�̂Ƃ�
                    Else
                        '�u0�v���ڍs
                        strNinteiSQL = strNinteiSQL & "0,"
                    End If
                End If
                '�v����ԋ敪�R�[�h�̃f�[�^���ڍs
                strNinteiSQL = strNinteiSQL & recNINTEIRIREKI("nurs_stat") & ","
                '�\�����̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI("apply_date")) Then
                    '�uNULL�v������o�^
                    strNinteiSQL = strNinteiSQL & "NULL" & ","
                'NULL�łȂ���
                Else
                    '�\�����̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI("apply_date") & "',"
                End If
                '�F����̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI("fixed_date")) Then
                    '�uNULL�v�������ڍs
                    strNinteiSQL = strNinteiSQL & "NULL" & ","
                'NULL�ȊO
                Else
                    '�F����̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI("fixed_date") & "',"
                End If
                '�L�����ԊJ�n�̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI("valid_from")) Then
                    '�uNULL�v�������ڍs
                    strNinteiSQL = strNinteiSQL & "'0001-01-01',"
                'NULL�łȂ���
                Else
                    '�L�����ԊJ�n�̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI("valid_from") & "',"
                End If
                '�L�����ԏI���̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI("valid_thru")) Then
                    '�uNULL�v�������ڍs
                    strNinteiSQL = strNinteiSQL & "'" & Format("9999-12-31", "yyyy/mm/dd") & "',"
                'NULL�ȊO
                Else
                    '�L�����ԏI���̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI("valid_thru") & "',"
                End If
                '���f�N���̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI("broken_off_date")) Then
                    '�uNULL�v�������ڍs
                    strNinteiSQL = strNinteiSQL & "NULL" & ","
                'NULL�ȊO
                Else
                    '���f�N���̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI("broken_off_date") & "',"
                End If
                '���f���R�̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI("broken_off_reason")) Then
                    '�u0�v���ڍs
                    strNinteiSQL = strNinteiSQL & "0,"
                'NULL�ȊO
                Else
                    '���f���R�̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & recNINTEIRIREKI("broken_off_reason") & ","
                End If
                '����T�[�r�X�v��쐬�˗��͏o���̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI("reported_date")) Then
                    '�uNULL�v�����̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "NULL" & ","
                'NULL�ȊO
                Else
                    '����T�[�r�X�v��쐬�˗��͏o���̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI("reported_date") & "',"
                End If
                '�x�����x�z�̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI("provision_limit1")) Then
                    '�u0�v���f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "0,"
                Else
                    '�x�����x�z�̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & recNINTEIRIREKI("provision_limit1") & ","
                End If
                '�O�����p�^�x�����x�z�̃f�[�^���ڍs
                If recNINTEIRIREKI("nurs_stat") = "01" Then
                    strNinteiSQL = strNinteiSQL & "0,"
                ElseIf recNINTEIRIREKI("nurs_stat") = "11" Then
                    strNinteiSQL = strNinteiSQL & "6505,"
                ElseIf recNINTEIRIREKI("nurs_stat") = "21" Then
                    strNinteiSQL = strNinteiSQL & "16689,"
                ElseIf recNINTEIRIREKI("nurs_stat") = "22" Then
                    strNinteiSQL = strNinteiSQL & "18726,"
                ElseIf recNINTEIRIREKI("nurs_stat") = "23" Then
                    strNinteiSQL = strNinteiSQL & "20763,"
                ElseIf recNINTEIRIREKI("nurs_stat") = "24" Then
                    strNinteiSQL = strNinteiSQL & "22800,"
                ElseIf recNINTEIRIREKI("nurs_stat") = "25" Then
                    strNinteiSQL = strNinteiSQL & "24867,"
                End If
                '�ŏI�X�V���ɃV�X�e�����t��o�^
                strNinteiSQL = strNinteiSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
                strNinteiSQL = strNinteiSQL & ")"
                
                Call FDBExecuteSQL(strNinteiSQL)

            '�F�藚���̗L�����Ԃ���Ńf�[�^�����鎞
            ElseIf Not recNINTEIRIREKI_COUNT.EOF Then
                '�F�藚�����e�[�u�����ڍs
                strNinteiSQL = ""
                strNinteiSQL = strNinteiSQL & "INSERT INTO PATIENT_NINTEI_HISTORY ("
                strNinteiSQL = strNinteiSQL & "PATIENT_ID,"
                strNinteiSQL = strNinteiSQL & "NINTEI_HISTORY_ID,"
                strNinteiSQL = strNinteiSQL & "INSURER_ID,"
                strNinteiSQL = strNinteiSQL & "INSURED_ID,"
                strNinteiSQL = strNinteiSQL & "INSURE_RATE,"
                strNinteiSQL = strNinteiSQL & "PLANNER,"
                strNinteiSQL = strNinteiSQL & "PROVIDER_ID,"
                strNinteiSQL = strNinteiSQL & "SHUBETSU_CODE,"
                strNinteiSQL = strNinteiSQL & "CHANGE_CODE,"
                strNinteiSQL = strNinteiSQL & "JOTAI_CODE,"
                strNinteiSQL = strNinteiSQL & "SHINSEI_DATE,"
                strNinteiSQL = strNinteiSQL & "NINTEI_DATE,"
                strNinteiSQL = strNinteiSQL & "INSURE_VALID_START,"
                strNinteiSQL = strNinteiSQL & "INSURE_VALID_END,"
                strNinteiSQL = strNinteiSQL & "STOP_DATE,"
                strNinteiSQL = strNinteiSQL & "STOP_REASON,"
                strNinteiSQL = strNinteiSQL & "REPORTED_DATE,"
                strNinteiSQL = strNinteiSQL & "LIMIT_RATE,"
                strNinteiSQL = strNinteiSQL & "EXTERNAL_USE_LIMIT,"
                strNinteiSQL = strNinteiSQL & "LAST_TIME"
                strNinteiSQL = strNinteiSQL & ")"
                
                strNinteiSQL = strNinteiSQL & " VALUES ("
                '���p�Ҕԍ��̃f�[�^���ڍs
                strNinteiSQL = strNinteiSQL & recPATIENT("pat_id") & ","
                '�F�藚��ԍ��Ɂu1�v��o�^
                strNinteiSQL = strNinteiSQL & "'" & 1 & "',"
                '�ی��Ҕԍ��̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recPATIENT("insr_no")) Then
                    '��̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "'',"
                Else
                    '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g�ƒu���j
                    strNinteiSQL = strNinteiSQL & "'" & Replace(recPATIENT("insr_no"), "'", "''") & "',"
                End If
                '��ی��Ҕԍ��̃f�[�^�ڍs
                If IsNull(recPATIENT("insd_no")) Then
                    '��̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "'',"
                Else
                    '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g�ƒu���j
                    strNinteiSQL = strNinteiSQL & "'" & Replace(recPATIENT("insd_no"), "'", "''") & "',"
                End If
                '���t���̃f�[�^���ڍs
                strNinteiSQL = strNinteiSQL & recPATIENT("ins_rate") & ","
                '����v��쐬�҂̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recPATIENT("planner")) Then
                    '�u0�v���ڍs
                    strNinteiSQL = strNinteiSQL & "0,"
                'NULL�łȂ���
                Else
                    '����v��쐬�҂̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & recPATIENT("planner") & ","
                End If
                '����T�[�r�X�쐬���Ə��ԍ��̃f�[�^���ڍs
                strNinteiSQL = strNinteiSQL & "'" & recPATIENT("planner_no") & "',"
                '�\����ʃR�[�h�̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI_COUNT("apply_type")) Then
                    '�u0�v���ڍs
                    strNinteiSQL = strNinteiSQL & "0,"
                'NULL�łȂ���
                Else
                    '�\����ʃR�[�h�̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & recNINTEIRIREKI_COUNT("apply_type") & ","
                End If
                '�\�����R�[�h�̃f�[�^�ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI_COUNT("change_apply")) Then
                    '�u0�v���ڍs
                    strNinteiSQL = strNinteiSQL & "0,"
                'NULL�łȂ���
                Else
                    '�ڍs���f�[�^���u2�v��
                    If recNINTEIRIREKI_COUNT("change_apply") = 2 Then
                        '�u1�v���ڍs
                        strNinteiSQL = strNinteiSQL & "1,"
                    '�u2�v�ȊO�̂Ƃ�
                    Else
                        '�u0�v���ڍs
                        strNinteiSQL = strNinteiSQL & "0,"
                    End If
                End If
                '�v����ԋ敪�R�[�h�̃f�[�^���ڍs
                strNinteiSQL = strNinteiSQL & recNINTEIRIREKI_COUNT("nurs_stat") & ","
                '�\�����̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI_COUNT("apply_date")) Then
                    '�uNULL�v������o�^
                    strNinteiSQL = strNinteiSQL & "NULL" & ","
                'NULL�łȂ���
                Else
                    '�\�����̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI_COUNT("apply_date") & "',"
                End If
                '�F����̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI_COUNT("fixed_date")) Then
                    '�uNULL�v�������ڍs
                    strNinteiSQL = strNinteiSQL & "NULL" & ","
                'NULL�ȊO
                Else
                    '�F����̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI_COUNT("fixed_date") & "',"
                End If
                '�L�����ԊJ�n�̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI_COUNT("valid_from")) Then
                    '�uNULL�v�������ڍs
                    strNinteiSQL = strNinteiSQL & "'0001-01-01',"
                'NULL�łȂ���
                Else
                    '�L�����ԊJ�n�̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI_COUNT("valid_from") & "',"
                End If
                '�L�����ԏI���̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI_COUNT("valid_thru")) Then
                    '�uNULL�v�������ڍs
                    strNinteiSQL = strNinteiSQL & "'" & Format("9999-12-31", "yyyy/mm/dd") & "',"
                'NULL�ȊO
                Else
                    '�L�����ԏI���̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI_COUNT("valid_thru") & "',"
                End If
                '���f�N���̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI_COUNT("broken_off_date")) Then
                    '�uNULL�v�������ڍs
                    strNinteiSQL = strNinteiSQL & "NULL" & ","
                'NULL�ȊO
                Else
                    '���f�N���̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI_COUNT("broken_off_date") & "',"
                End If
                '���f���R�̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI_COUNT("broken_off_reason")) Then
                    '�u0�v���ڍs
                    strNinteiSQL = strNinteiSQL & "0,"
                'NULL�ȊO
                Else
                    '���f���R�̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & recNINTEIRIREKI_COUNT("broken_off_reason") & ","
                End If
                '����T�[�r�X�v��쐬�˗��͏o���̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI_COUNT("reported_date")) Then
                    '�uNULL�v�����̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "NULL" & ","
                'NULL�ȊO
                Else
                    '����T�[�r�X�v��쐬�˗��͏o���̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI_COUNT("reported_date") & "',"
                End If
                '�x�����x�z�̃f�[�^���ڍs
                'NULL�̎�
                If IsNull(recNINTEIRIREKI_COUNT("provision_limit1")) Then
                    '�u0�v���f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & "0,"
                Else
                    '�x�����x�z�̃f�[�^���ڍs
                    strNinteiSQL = strNinteiSQL & recNINTEIRIREKI_COUNT("provision_limit1") & ","
                End If
                '�O�����p�^�x�����x�z�̃f�[�^���ڍs
                If recNINTEIRIREKI_COUNT("nurs_stat") = "01" Then
                    strNinteiSQL = strNinteiSQL & "0,"
                ElseIf recNINTEIRIREKI_COUNT("nurs_stat") = "11" Then
                    strNinteiSQL = strNinteiSQL & "6505,"
                ElseIf recNINTEIRIREKI_COUNT("nurs_stat") = "21" Then
                    strNinteiSQL = strNinteiSQL & "16689,"
                ElseIf recNINTEIRIREKI_COUNT("nurs_stat") = "22" Then
                    strNinteiSQL = strNinteiSQL & "18726,"
                ElseIf recNINTEIRIREKI_COUNT("nurs_stat") = "23" Then
                    strNinteiSQL = strNinteiSQL & "20763,"
                ElseIf recNINTEIRIREKI_COUNT("nurs_stat") = "24" Then
                    strNinteiSQL = strNinteiSQL & "22800,"
                ElseIf recNINTEIRIREKI_COUNT("nurs_stat") = "25" Then
                    strNinteiSQL = strNinteiSQL & "24867,"
                End If
                '�ŏI�X�V���ɃV�X�e�����t��o�^
                strNinteiSQL = strNinteiSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
                strNinteiSQL = strNinteiSQL & ")"
            
                Call FDBExecuteSQL(strNinteiSQL)
            
            End If
    
        recPATIENT.MoveNext
    Loop
    
    Exit Sub
    
Err_Connection:

    MsgBox "�f�[�^�̈ڍs�Ɏ��s���܂����B" & vbNewLine & "�\���󂠂�܂��񂪁A�f�[�^�̈ڍs���͂��߂����蒼���Ă��������B" _
    , vbInformation + vbOKOnly, "�f�[�^�ڍs���s"
    
    End

End Sub

Public Sub ConvPROVIDER()
'============================================================================================
'���Ǝҏ��ڍs�i�S���ʁj
'============================================================================================
Dim strSQL As String
Dim strSQLStaff As String
Dim varTel As Variant
Dim varFax As Variant
Dim varStaff As Variant
Dim varStaffName As Variant
Dim recPROVIDER As Object

    '�G���[����
    On Error GoTo Err_Connection

    '���Ǝҏ��e�[�u���̎擾
    Set recPROVIDER = MDBExecuteRecordSet("SELECT * FROM m_pvd", adOpenForwardOnly, adLockReadOnly)
    
    '���Ǝҏ�񐔕���������
    Do Until recPROVIDER.EOF
        '�X�^�b�t���̃f�[�^���ڍs
        '�X�^�b�t�f�[�^����łȂ���
        If recPROVIDER("pvd_man_nm") <> "" Then
            varStaff = Split(recPROVIDER("pvd_man_nm"), Chr(9))
            Dim i
            For i = 0 To UBound(varStaff)
                '�X�^�b�t�����𕪊�
                If InStr(varStaff(i), " ") <> 0 Then
                    varStaffName = Split(varStaff(i), " ")
                ElseIf InStr(varStaff(i), "�@") <> 0 Then
                    varStaffName = Split(varStaff(i), "�@")
                Else
                    varStaffName = varStaff(i)
                End If
            
                strSQLStaff = ""
                strSQLStaff = strSQLStaff & "INSERT INTO STAFF ("
                strSQLStaff = strSQLStaff & "PROVIDER_ID,"
                strSQLStaff = strSQLStaff & "STAFF_ID,"
                strSQLStaff = strSQLStaff & "STAFF_FAMILY_NAME,"
                strSQLStaff = strSQLStaff & "STAFF_FIRST_NAME,"
                strSQLStaff = strSQLStaff & "LAST_TIME"
                strSQLStaff = strSQLStaff & ")"
            
                strSQLStaff = strSQLStaff & " VALUES ("
                '���Ə��ԍ��̃f�[�^���ڍs
                strSQLStaff = strSQLStaff & "'" & recPROVIDER("pvd_no") & "',"
                '�X�^�b�t�ԍ���i+1��o�^
                strSQLStaff = strSQLStaff & i + 1 & ","
                '�X�^�b�t�����̐��ɕ��������f�[�^�̍ŏ����ڍs
                If InStr(varStaff(i), " ") <> 0 Or InStr(varStaff(i), "�@") <> 0 Then
                    'NULL�łȂ���
                    If IsNull(varStaffName(0)) Then
                        strSQLStaff = strSQLStaff & "'',"
                    Else
                        '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
                        strSQLStaff = strSQLStaff & "'" & Replace(varStaffName(0), "'", "''") & "',"
                    End If
                Else
                    'NULL�łȂ���
                    If IsNull(varStaffName) Then
                        strSQLStaff = strSQLStaff & "'',"
                    Else
                        '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
                        strSQLStaff = strSQLStaff & "'" & Replace(varStaffName, "'", "''") & "',"
                    End If
                End If
                '�X�^�b�t�����̐��ɕ��������f�[�^�̍ŏ����ڍs
                '���������f�[�^��0�ȏ�̎�
                If InStr(varStaff(i), " ") > 0 Then
                    'NULL�łȂ���
                    If IsNull(varStaffName(1)) Then
                        strSQLStaff = strSQLStaff & "'',"
                    Else
                        '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
                        strSQLStaff = strSQLStaff & "'" & Replace(varStaffName(1), "'", "''") & "',"
                    End If
                ElseIf InStr(varStaff(i), "�@") > 0 Then
                    'NULL�łȂ��Ƃ�
                    If IsNull(varStaffName(1)) Then
                        strSQLStaff = strSQLStaff & "'',"
                    Else
                        strSQLStaff = strSQLStaff & "'" & Replace(varStaffName(1), "'", "''") & "',"
                    End If
                Else
                    strSQLStaff = strSQLStaff & "'',"
                End If
                '�ŏI�X�V���ɃV�X�e�����t��o�^
                strSQLStaff = strSQLStaff & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
                strSQLStaff = strSQLStaff & ")"
                
                Call FDBExecuteSQL(strSQLStaff)
            Next i
        
        End If
    
        '�d�b�ԍ�/FAX�ԍ����n�C�t���ŕ���
        If InStr(recPROVIDER("pvd_tel"), "-") <> 0 Then
            varTel = Split(StrConv(recPROVIDER("pvd_tel"), vbNarrow), "-")
        Else
            varTel = recPROVIDER("pvd_tel")
        End If
        If InStr(recPROVIDER("pvd_fax"), "-") <> 0 Then
            varFax = Split(StrConv(recPROVIDER("pvd_fax"), vbNarrow), "-")
        Else
            varFax = recPROVIDER("pvd_fax")
        End If
        
        '���Ə����e�[�u�����ڍs
        strSQL = ""
        strSQL = strSQL & "INSERT INTO PROVIDER ("
        strSQL = strSQL & "PROVIDER_ID,"
        strSQL = strSQL & "PROVIDER_TYPE,"
        strSQL = strSQL & "MEDICAL_FLAG,"
        strSQL = strSQL & "PROVIDER_NAME,"
        strSQL = strSQL & "PROVIDER_ZIP_FIRST,"
        strSQL = strSQL & "PROVIDER_ZIP_SECOND,"
        strSQL = strSQL & "PROVIDER_ADDRESS,"
        strSQL = strSQL & "PROVIDER_TEL_FIRST,"
        strSQL = strSQL & "PROVIDER_TEL_SECOND,"
        strSQL = strSQL & "PROVIDER_TEL_THIRD,"
        strSQL = strSQL & "PROVIDER_FAX_FIRST,"
        strSQL = strSQL & "PROVIDER_FAX_SECOND,"
        strSQL = strSQL & "PROVIDER_FAX_THIRD,"
        strSQL = strSQL & "PROVIDER_JIJIGYOUSHO_TYPE,"
        strSQL = strSQL & "PROVIDER_JIGYOU_TYPE,"
        strSQL = strSQL & "PROVIDER_AREA_TYPE,"
        strSQL = strSQL & "SPECIAL_AREA_FLAG,"
        strSQL = strSQL & "PROVIDER_OWNER_NAME,"
        strSQL = strSQL & "DELETE_FLAG,"
        strSQL = strSQL & "LAST_TIME"
        strSQL = strSQL & ")"
        
        strSQL = strSQL & " VALUES ("
        '���Ə��ԍ��̃f�[�^���ڍs
        strSQL = strSQL & "'" & recPROVIDER("pvd_no") & "',"
        '���Ə���ʂɁu0�v��o�^
        strSQL = strSQL & "0,"
        '��Ë@�փt���O�Ɂu0�v��o�^
        strSQL = strSQL & "0,"
        '���Ə����̃f�[�^���ڍs
        'NULL�̎�
        If IsNull(recPROVIDER("pvd_nm")) Then
            strSQL = strSQL & "'',"
        Else
            '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
            strSQL = strSQL & "'" & Replace(recPROVIDER("pvd_nm"), "'", "''") & "',"
        End If
        '�X�֔ԍ��̃f�[�^���ڍs
        'NULL�̎�
        If IsNull(recPROVIDER("pvd_zip_code")) Then
            '��f�[�^��2�ڍs
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        '�ڍs���̃f�[�^�̒�����3�ȏ�̎�
        ElseIf Len(recPROVIDER("pvd_zip_code")) > 3 Then
            '������3���̃f�[�^���ڍs
            strSQL = strSQL & "'" & Left$(recPROVIDER("pvd_zip_code"), 3) & "',"
            '4������f�[�^�̍ŏI�܂ł��ڍs
            strSQL = strSQL & "'" & Mid$(recPROVIDER("pvd_zip_code"), 4, Len(recPROVIDER("pvd_zip_code"))) & "',"
        '��L�ȊO
        Else
            '������3���̃f�[�^���ڍs
            strSQL = strSQL & "'" & Left$(recPROVIDER("pvd_zip_code"), 3) & "',"
            '��̃f�[�^���ڍs
            strSQL = strSQL & "'',"
        End If
        '�Z���̃f�[�^���ڍs
        If IsNull(recPROVIDER("pvd_address")) Then
            strSQL = strSQL & "'',"
        Else
            '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
            strSQL = strSQL & "'" & Replace(recPROVIDER("pvd_address"), "'", "''") & "',"
        End If
        '�d�b�ԍ��̃f�[�^���ڍs
        'NULL�̎�
        If IsNull(recPROVIDER("pvd_tel")) Then
            '��̃f�[�^��3�ڍs
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        '�n�C�t���ŕ��������f�[�^��0�ȊO�̂Ƃ�
        ElseIf InStr(recPROVIDER("pvd_tel"), "-") <> 0 Then
            '���l�^�̃`�F�b�N
            If IsNumeric(varTel(0)) = True Then
                '������6���̃f�[�^���ڍs
                strSQL = strSQL & "'" & Left$(varTel(0), 6) & "',"
            '���l�^�łȂ��Ƃ�
            Else
                '��̃f�[�^���ڍs
                strSQL = strSQL & "'',"
            End If
            '���������f�[�^��0�ȏ�
            If UBound(varTel) > 0 Then
                '���l�^�̎�
                If IsNumeric(varTel(1)) = True Then
                    'NULL�Ŗ������A������4���̃f�[�^���ڍs
                    If Not IsNull(varTel(1)) Then
                        strSQL = strSQL & "'" & Left$(varTel(1), 4) & "',"
                    'NULL�̎�
                    Else
                        '��̃f�[�^���ڍs
                        strSQL = strSQL & "'',"
                    End If
                '���l�^�łȂ��Ƃ�
                Else
                    '��̃f�[�^���ڍs
                    strSQL = strSQL & "'',"
                End If
            '���������f�[�^��0�ȉ��̎�
            Else
                '��̃f�[�^���ڍs
                strSQL = strSQL & "'',"
            End If
            '���������f�[�^��1�ȏ�̎�
            If UBound(varTel) > 1 Then
                '���l�^�̃`�F�b�N
                If IsNumeric(varTel(2)) = True Then
                    'NULL�Ŗ�����
                    If Not IsNull(varTel(2)) Then
                        '������4���̃f�[�^���ڍs
                        strSQL = strSQL & "'" & Left$(varTel(2), 4) & "',"
                    Else
                        '��̃f�[�^���ڍs
                        strSQL = strSQL & "'',"
                    End If
                '���l�^�łȂ��Ƃ�
                Else
                    '��̃f�[�^���ڍs
                    strSQL = strSQL & "'',"
                End If
            '���������f�[�^��1�ȉ�
            Else
                '��̃f�[�^���ڍs
                strSQL = strSQL & "'',"
            End If
        '�d�b�ԍ���NULL�łȂ��A���������f�[�^���u0�v�̎�
        Else
            '���l�^�̃`�F�b�N
            If IsNumeric(varTel) = True Then
                '������6���̃f�[�^���ڍs
                strSQL = strSQL & "'" & Left$(varTel, 6) & "',"
            '���l�^�łȂ��Ƃ�
            Else
                '��̃f�[�^���ڍs
                strSQL = strSQL & "'',"
            End If
            '��̃f�[�^��2�ڍs
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        End If
        'FAX�ԍ��̃f�[�^���ڍs
        'NULL�̎�
        If IsNull(recPROVIDER("pvd_fax")) Then
            '��f�[�^��3��ڍs
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        '�n�C�t���ŋ�؂����f�[�^�̌���0�ȊO�Ȃ�
        ElseIf InStr(recPROVIDER("pvd_fax"), "-") <> 0 Then
            '���l�^�̎�
            If IsNumeric(varFax(0)) = True Then
                '������6�����ڍs
                strSQL = strSQL & "'" & Left$(varFax(0), 6) & "',"
            '���l�^�ȊO
            Else
                '��f�[�^���ڍs
                strSQL = strSQL & "'',"
            End If
            '��؂����f�[�^�̌���0�ȏ�
            If UBound(varFax) > 0 Then
                '���l�^�̎�
                If IsNumeric(varFax(1)) = True Then
                    'NULL�ȊO�̂Ƃ�
                    If Not IsNull(varFax(1)) Then
                        '������4���̃f�[�^���ڍs
                        strSQL = strSQL & "'" & Left$(varFax(1), 4) & "',"
                    Else
                        '��f�[�^���ڍs
                        strSQL = strSQL & "'',"
                    End If
                Else
                    '��̃f�[�^���ڍs
                    strSQL = strSQL & "'',"
                End If
            '��؂����f�[�^�̌���0�̎�
            Else
                '��̃f�[�^���ڍs
                strSQL = strSQL & "'',"
            End If
            '�n�C�t���ŋ�؂����f�[�^�̌���1�ȏ�
            If UBound(varFax) > 1 Then
                '���l�^�̎�
                If IsNumeric(varFax(2)) = True Then
                    'NULL�ȊO
                    If Not IsNull(varFax(2)) Then
                        '������4���̃f�[�^���ڍs
                        strSQL = strSQL & "'" & Left$(varFax(2), 4) & "',"
                    'NULL�̎�
                    Else
                        '��̃f�[�^���ڍs
                        strSQL = strSQL & "'',"
                    End If
                '���l�^�łȂ���
                Else
                    '��̃f�[�^���ڍs
                    strSQL = strSQL & "'',"
                End If
            '��؂����f�[�^�̌���1�ȉ�
            Else
                '��̃f�[�^���ڍs
                strSQL = strSQL & "'',"
            End If
        'NULL�łȂ��A��؂�f�[�^��������
        Else
            '���l�^�̎�
            If IsNumeric(varFax) = True Then
                '������6�����ڍs
                strSQL = strSQL & "'" & Left$(varFax, 6) & "',"
            '���l�^�łȂ��Ƃ�
            Else
                '��f�[�^���ڍs
                strSQL = strSQL & "'',"
            End If
            '��f�[�^��2�ڍs
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        End If
        '���Ə��敪�̃f�[�^�ڍs
        '��łȂ���
        If Not IsNull(recPROVIDER("pvd_self_flg")) Then
            '���Ə��敪��1��2�����ւ���B
            strSQL = IIf(recPROVIDER("pvd_self_flg") = 1, strSQL & "2,", strSQL & "1,")
        '��̎�
        Else
            strSQL = strSQL & "0,"
        End If
        '���Ə���ʂ̃f�[�^���ڍs
        strSQL = strSQL & recPROVIDER("designate_type") & ","
        '�n��敪��6�̎��̓f�[�^���ڍs���Ȃ��B
        strSQL = IIf(recPROVIDER("area_type") = 6, strSQL & "5,", strSQL & recPROVIDER("area_type") & ",")
        '���ʒn���1��0�ɂ�2��1�ɓ���ւ���B
        strSQL = IIf(recPROVIDER("sp_area_flg") = 1, strSQL & "1,", strSQL & "2,")
        '�J�ݎҎ����̃f�[�^���ڍs
        'NULL�̂Ƃ�
        If IsNull(recPROVIDER("owner_nm")) Then
            strSQL = strSQL & "'',"
        Else
            '�ڍs���̃f�[�^���ڍs�i�V���O���N�H�[�g��u���j
            strSQL = strSQL & "'" & Replace(recPROVIDER("owner_nm"), "'", "''") & "',"
        End If
        '�폜�t���O�̃f�[�^���ڍs
        strSQL = strSQL & "0,"
        '�ŏI�X�V���ɃV�X�e�����t��o�^
        strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
        strSQL = strSQL & ")"
        
        Call FDBExecuteSQL(strSQL)
    
        recPROVIDER.MoveNext
    Loop
    
    Exit Sub
                                                            
Err_Connection:

    MsgBox "�f�[�^�̈ڍs�Ɏ��s���܂����B" & vbNewLine & "�\���󂠂�܂��񂪁A�f�[�^�̈ڍs���͂��߂����蒼���Ă��������B" _
    , vbInformation + vbOKOnly, "�f�[�^�ڍs���s"
    
    End
                                                            
End Sub

Public Sub ConvPROVIDERSERVICE_Insert(intProviderServiceID As Long, strProviderID As String, intSystemServiceKindDetail As Variant _
                               , intReductRate As Integer)
'============================================================================================
'���Ə��T�[�r�X���ڍs�i�S���ʁj
'============================================================================================
Dim strSQL As String
                               
    '�G���[����
    On Error GoTo Err_Connection
                               
    '���Ə��T�[�r�X���e�[�u�����ڍs
    strSQL = ""
    strSQL = strSQL & "INSERT INTO PROVIDER_SERVICE ("
    strSQL = strSQL & "PROVIDER_SERVICE_ID,"
    strSQL = strSQL & "PROVIDER_ID,"
    strSQL = strSQL & "SYSTEM_SERVICE_KIND_DETAIL,"
    strSQL = strSQL & "REDUCT_RATE,"
    strSQL = strSQL & "LAST_TIME"
    strSQL = strSQL & ")"
    
    strSQL = strSQL & " VALUES ("
    '���Ə��T�[�r�X�ԍ���o�^
    strSQL = strSQL & intProviderServiceID & ","
    '���Ə��ԍ���o�^
    strSQL = strSQL & "'" & strProviderID & "',"
    '�V�X�e���T�[�r�X��ނ�o�^
    strSQL = strSQL & intSystemServiceKindDetail & ","
    '��������o�^
    strSQL = strSQL & intReductRate & ","
    '�ŏI�X�V���ɃV�X�e�����t��o�^
    strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
    strSQL = strSQL & ")"
    
    Call FDBExecuteSQL(strSQL)
    
    Exit Sub

Err_Connection:

    MsgBox "�f�[�^�̈ڍs�Ɏ��s���܂����B" & vbNewLine & "�\���󂠂�܂��񂪁A�f�[�^�̈ڍs���͂��߂����蒼���Ă��������B" _
    , vbInformation + vbOKOnly, "�f�[�^�ڍs���s"
    
    End

End Sub

Public Sub ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID As Long, varSystemBindPath As Variant, intDetailValue As Integer)
'============================================================================================
'���Ə��T�[�r�X�ڍ׏��ڍs�i���l�^�j
'============================================================================================
Dim strSQL As String
                               
    '�G���[����
    On Error GoTo Err_Connection
                               
    '���Ə��T�[�r�X���e�[�u�����ڍs
    strSQL = ""
    strSQL = strSQL & "INSERT INTO PROVIDER_SERVICE_DETAIL_INTEGER ("
    strSQL = strSQL & "PROVIDER_SERVICE_ID,"
    strSQL = strSQL & "SYSTEM_BIND_PATH,"
    strSQL = strSQL & "DETAIL_VALUE,"
    strSQL = strSQL & "LAST_TIME"
    strSQL = strSQL & ")"
    
    strSQL = strSQL & " VALUES ("
    '���Ə��T�[�r�X�ԍ���o�^
    strSQL = strSQL & intProviderServiceID & ","
    '�V�X�e���o�C���h�p�X��o�^
    strSQL = strSQL & varSystemBindPath & ","
    '�o�C���h�p�X�̒l��o�^
    strSQL = strSQL & intDetailValue & ","
    '�ŏI�X�V���ɃV�X�e�����t��o�^
    strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
    strSQL = strSQL & ")"
    
    Call FDBExecuteSQL(strSQL)
    
    Exit Sub

Err_Connection:

    MsgBox "�f�[�^�̈ڍs�Ɏ��s���܂����B" & vbNewLine & "�\���󂠂�܂��񂪁A�f�[�^�̈ڍs���͂��߂����蒼���Ă��������B" _
    , vbInformation + vbOKOnly, "�f�[�^�ڍs���s"
    
    End

End Sub

Public Sub ConvPROVIDERSERVICEDETAILSQLStr(intProviderServiceID As Long, varSystemBindPath As Variant, strDetailValue As String)
'============================================================================================
'���Ə��T�[�r�X�ڍ׏��ڍs�i������^�j
'============================================================================================
Dim strSQL As String
                               
    '�G���[����
    On Error GoTo Err_Connection
                               
    '���Ə��T�[�r�X���e�[�u�����ڍs
    strSQL = ""
    strSQL = strSQL & "INSERT INTO PROVIDER_SERVICE_DETAIL_TEXT ("
    strSQL = strSQL & "PROVIDER_SERVICE_ID,"
    strSQL = strSQL & "SYSTEM_BIND_PATH,"
    strSQL = strSQL & "DETAIL_VALUE,"
    strSQL = strSQL & "LAST_TIME"
    strSQL = strSQL & ")"
    
    strSQL = strSQL & " VALUES ("
    '���Ə��T�[�r�X�ԍ��̃f�[�^��o�^
    strSQL = strSQL & intProviderServiceID & ","
    '�V�X�e���o�C���h�p�X��o�^
    strSQL = strSQL & varSystemBindPath & ","
    '�o�C���h�p�X�̒l��o�^
    strSQL = strSQL & "'" & strDetailValue & "',"
    '�ŏI�X�V���ɃV�X�e�����t��o�^
    strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
    strSQL = strSQL & ")"
    
    Call FDBExecuteSQL(strSQL)
    
    Exit Sub

Err_Connection:

    MsgBox "�f�[�^�̈ڍs�Ɏ��s���܂����B" & vbNewLine & "�\���󂠂�܂��񂪁A�f�[�^�̈ڍs���͂��߂����蒼���Ă��������B" _
    , vbInformation + vbOKOnly, "�f�[�^�ڍs���s"
    
    End

End Sub

Public Sub ConvPROVIDERMENU(varLoginProviderID As Variant, intMenuID As Integer, intShowFlag As Integer)
'============================================================================================
'���Ə��T�[�r�X�ڍ׏��ڍs�i������^�j
'============================================================================================
Dim strSQL As String
                               
    '�G���[����
    On Error GoTo Err_Connection
                               
    '���Ə��T�[�r�X���e�[�u�����ڍs
    strSQL = ""
    strSQL = strSQL & "INSERT INTO PROVIDER_MENU ("
    strSQL = strSQL & "LOGIN_PROVIDER_ID,"
    strSQL = strSQL & "MENU_ID,"
    strSQL = strSQL & "SHOW_FLAG,"
    strSQL = strSQL & "LAST_TIME"
    strSQL = strSQL & ")"
    
    strSQL = strSQL & " VALUES ("
    '���O�C�����Ə��ԍ��̃f�[�^��o�^
    strSQL = strSQL & "'" & varLoginProviderID & "',"
    '���j���[�ԍ��̃f�[�^��o�^
    strSQL = strSQL & intMenuID & ","
    '�\���t���O��o�^
    strSQL = strSQL & intShowFlag & ","
    '�ŏI�X�V���ɃV�X�e�����t��o�^
    strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
    strSQL = strSQL & ")"
    
    Call FDBExecuteSQL(strSQL)
    
    Exit Sub

Err_Connection:

    MsgBox "�f�[�^�̈ڍs�Ɏ��s���܂����B" & vbNewLine & "�\���󂠂�܂��񂪁A�f�[�^�̈ڍs���͂��߂����蒼���Ă��������B" _
    , vbInformation + vbOKOnly, "�f�[�^�ڍs���s"
    
    End

End Sub

Public Sub ConvPROVIDERSERVICE()
'Public Sub ConvPROVIDERSERVICE(ini As String, iniProviderServiceDetail As String)
'============================================================================================
'���Ə��T�[�r�X���ڍs�i�S���ʁj
'============================================================================================
Dim intProviderServiceID As Long                     '���Ə��T�[�r�XID
Dim intLogicalAdd As Integer                         '�_���a�̐�
Dim intMMenu As Integer                              '���j���[ID�̐�


Dim recPROVIDERSERVICE As Object                     '�T�[�r�X���̃��R�[�h�Z�b�g�i���j
Dim recPROVIDERSERVICENEW As Object                  '�T�[�r�X���̃��R�[�h�Z�b�g�i�V�j
Dim recPROVIDERSERVIDEMAX As Object                  '�T�[�r�X���̍ő�l
Dim recMSERVICE As Object                            '�T�[�r�X�}�X�^
Dim recMMENU As Object                               '���j���[�}�X�^

'���[�v�p
Dim i As Integer
Dim j As Integer

'���Ə��ԍ���old�l
Dim varProviderID_old As Variant
'���Ə��ԍ��ƃT�[�r�X��ނ̓񎟌��z��
Dim varProviderIDToSystemKindDetail(1000, 10000) As Variant
'���Ə��ԍ��̔z��
Dim strProviderID(2000) As String
Dim varProviderID As Variant

'�_���a
Dim LogicalAdd(1000) As Long
'�_����
Dim LogicalProduct(1000, 10000) As Long
'���j���[ID�̔z��
Dim intMenuID(1000, 10000) As Integer
    
    '�G���[����
    On Error GoTo Err_Connection
    
    '���Ə��T�[�r�X���e�[�u���̎擾
    Set recPROVIDERSERVICE = MDBExecuteRecordSet("SELECT * FROM m_pvd", adOpenForwardOnly, adLockReadOnly)
    
    '���Ə��T�[�r�XID�̏����l
    intProviderServiceID = 1
    '���Ə��T�[�r�X��񐔕���������
    Do Until recPROVIDERSERVICE.EOF
        
'==============================================================================================================================
'�K����̃f�[�^�ڍs
        If recPROVIDERSERVICE("svc11_flg") = 2 Then
            '���Ə��T�[�r�X�ڍs
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "11111", recPROVIDERSERVICE("reduce11"))
            
            'Ver3.5�̎�
            If GetDBVersion = VER35 Then
                '�Љ���y���[�u
                '�ڍs���f�[�^��2�̎�
                If Not IsNull(recPROVIDERSERVICE("svc11_shafuku")) Then
                    If recPROVIDERSERVICE("svc11_shafuku") = 2 Then
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1", "2")
                    End If
                End If
            End If
        
            '���Ə��T�[�r�XID��1��������
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'�K��������̃f�[�^�ڍs
        If recPROVIDERSERVICE("svc12_flg") = 2 Then
            '���Ə��T�[�r�X�ڍs
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "11211", recPROVIDERSERVICE("reduce12"))
        
            '���Ə��T�[�r�XID��1��������
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'�K��Ō�̃f�[�^�ڍs
        If recPROVIDERSERVICE("svc13_flg") = 2 Then
            '���Ə��T�[�r�X�ڍs
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "11311", recPROVIDERSERVICE("reduce13"))
            
            '�{�݋敪���ڍs
            If Not IsNull(recPROVIDERSERVICE("svc13_est")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1130101", recPROVIDERSERVICE("svc13_est"))
            End If
            '���ʊǗ��̐����ڍs
            If Not IsNull(recPROVIDERSERVICE("svc13_sp_management")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1130102", recPROVIDERSERVICE("svc13_sp_management"))
            End If
            '�Ǘ��Ҏ������ڍs
            If Not IsNull(recPROVIDERSERVICE("svc00_manager_nm")) Then
                Call ConvPROVIDERSERVICEDETAILSQLStr(intProviderServiceID, "1130103", Replace(recPROVIDERSERVICE("svc00_manager_nm"), "'", "''"))
            End If
            '�ً}���K��Ō�̐����ڍs
            If Not IsNull(recPROVIDERSERVICE("svc13_emergency")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1130104", recPROVIDERSERVICE("svc13_emergency"))
            End If
            'Ver2.0�̎��́A�i��Áj���̃f�[�^���ڍs
            If GetDBVersion = VER20 Then
                '��Õی��X�e�[�V�����R�[�h���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc00_station_cd")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLStr(intProviderServiceID, "2010101", Replace(recPROVIDERSERVICE("svc00_station_cd"), "'", "''"))
                End If
                '24���ԘA���̐����Z�̃f�[�^���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc00_24h")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLStr(intProviderServiceID, "2010102", recPROVIDERSERVICE("svc00_24h"))
                End If
                '�d�ǎҊǗ����Z�̃f�[�^���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc00_serious_disease")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLStr(intProviderServiceID, "2010103", recPROVIDERSERVICE("svc00_serious_disease"))
                End If
            End If
            
            '���Ə��T�[�r�XID��1��������
            intProviderServiceID = intProviderServiceID + 1
            
            'Ver2.0�̎��́A�i��Áj���̃f�[�^���ڍs
            If GetDBVersion = VER20 Then
                '���Ə��T�[�r�X�ڍs
                Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
                "20101", recPROVIDERSERVICE("reduce13"))
                
                '�{�݋敪���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc13_est")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1130101", recPROVIDERSERVICE("svc13_est"))
                End If
                '���ʊǗ��̐����ڍs
                If Not IsNull(recPROVIDERSERVICE("svc13_sp_management")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1130102", recPROVIDERSERVICE("svc13_sp_management"))
                End If
                '�Ǘ��Ҏ������ڍs
                If Not IsNull(recPROVIDERSERVICE("svc00_manager_nm")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLStr(intProviderServiceID, "1130103", recPROVIDERSERVICE("svc00_manager_nm"))
                End If
                '�ً}���K��Ō�̐����ڍs
                If Not IsNull(recPROVIDERSERVICE("svc13_emergency")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1130104", recPROVIDERSERVICE("svc13_emergency"))
                End If
                '��Õی��X�e�[�V�����R�[�h���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc00_station_cd")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLStr(intProviderServiceID, "2010101", recPROVIDERSERVICE("svc00_station_cd"))
                End If
                
            End If
        
            '���Ə��T�[�r�XID��1��������
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
       
'==============================================================================================================================
'�K�⃊�n�̃f�[�^�ڍs
        If recPROVIDERSERVICE("svc14_flg") = 2 Then
            '���Ə��T�[�r�X�ڍs
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "11411", recPROVIDERSERVICE("reduce14"))
        
            'Ver3.5�̎�
            If GetDBVersion = VER35 Then
                '�{�݋敪���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc14_est")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1140101", recPROVIDERSERVICE("svc14_est"))
                End If
            End If
            
            '���Ə��T�[�r�XID��1��������
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'�ʏ����̃f�[�^�ڍs
        If recPROVIDERSERVICE("svc15_flg") = 2 Then
            '���Ə��T�[�r�X�ڍs
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "11511", recPROVIDERSERVICE("reduce15"))
        
            '�ʋ@�\�P���w���̐����ڍs
            If Not IsNull(recPROVIDERSERVICE("svc15_training")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1150102", recPROVIDERSERVICE("svc15_training"))
            End If
            '������̐����ڍs
            If Not IsNull(recPROVIDERSERVICE("svc15_bath")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1150103", recPROVIDERSERVICE("svc15_bath"))
            End If
            
            'Ver3.5�̎�
            If GetDBVersion = VER35 Then
                '�Љ���y���[�u
                '�ڍs���f�[�^��2�̎�
                If Not IsNull(recPROVIDERSERVICE("svc15_shafuku")) Then
                    If recPROVIDERSERVICE("svc15_shafuku") = 2 Then
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1", "2")
                    End If
                End If
            End If
        
            '���Ə��T�[�r�XID��1��������
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'�ʏ����n�̃f�[�^�ڍs
        If recPROVIDERSERVICE("svc16_flg") = 2 Then
            '���Ə��T�[�r�X�ڍs
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "11611", recPROVIDERSERVICE("reduce16"))
        
            '�{�݋敪���ڍs
            If Not IsNull(recPROVIDERSERVICE("svc16_est")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1160101", recPROVIDERSERVICE("svc16_est"))
            End If

            '������̐����ڍs
            If Not IsNull(recPROVIDERSERVICE("svc16_bath")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1160102", recPROVIDERSERVICE("svc16_bath"))
            End If

            '���Ə��T�[�r�XID��1��������
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'�����p��̃f�[�^�ڍs
        If recPROVIDERSERVICE("svc17_flg") = 2 Then
            '���Ə��T�[�r�X�ڍs
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "11711", recPROVIDERSERVICE("reduce17"))
       
            '���Ə��T�[�r�XID��1��������
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'�Z�������������̃f�[�^�ڍs
        If recPROVIDERSERVICE("svc21_flg") = 2 Then
            '���Ə��T�[�r�X�ڍs
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "12111", recPROVIDERSERVICE("reduce21"))
      
            '�{�݋敪���ڍs
            If Not IsNull(recPROVIDERSERVICE("svc21_est")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1210101", recPROVIDERSERVICE("svc21_est"))
            End If
            '��ԋΖ���������ڍs
            If Not IsNull(recPROVIDERSERVICE("svc21_nw")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1210102", recPROVIDERSERVICE("svc21_nw"))
            End If
            '�@�\�P���w���̐����ڍs
            If Not IsNull(recPROVIDERSERVICE("svc21_training")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1210103", recPROVIDERSERVICE("svc21_training"))
            End If
            '���}�̐����ڍs
            If Not IsNull(recPROVIDERSERVICE("svc21_ws")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1210104", recPROVIDERSERVICE("svc21_ws"))
            End If

            'Ver3.5�̎�
            If GetDBVersion = VER35 Then
                '�h�{�Ǘ��̐����ڍs
                If Not IsNull(recPROVIDERSERVICE("svc21_eiyoukanri")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1210105", recPROVIDERSERVICE("svc21_eiyoukanri"))
                End If
                '�Љ���y���[�u
                '�ڍs���f�[�^��2�̎�
                If Not IsNull(recPROVIDERSERVICE("svc21_shafuku")) Then
                    If recPROVIDERSERVICE("svc21_shafuku") = 2 Then
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1", "2")
                    End If
                End If
            End If

            '���Ə��T�[�r�XID��1��������
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'�Z�������×{���i�V���j�̃f�[�^�ڍs
        If recPROVIDERSERVICE("svc22_flg") = 2 Then
            '���Ə��T�[�r�X�ڍs
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "12211", recPROVIDERSERVICE("reduce22"))
                
            '��ԋΖ���������ڍs
            If Not IsNull(recPROVIDERSERVICE("svc22_nw")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1220102", recPROVIDERSERVICE("svc22_nw"))
            End If
            '���n�r���@�\�����̐����ڍs
            If Not IsNull(recPROVIDERSERVICE("svc22_reha")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1220103", recPROVIDERSERVICE("svc22_reha"))
            End If
            '���}�̐����ڍs
            If Not IsNull(recPROVIDERSERVICE("svc22_ws")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1220105", recPROVIDERSERVICE("svc22_ws"))
            End If
        
            'Ver3.5�̎�
            If GetDBVersion = VER35 Then
                '�{�݋敪���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc22_unit")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1220101", recPROVIDERSERVICE("svc22_unit"))
                End If
                '�h�{�Ǘ��̐����ڍs
                If Not IsNull(recPROVIDERSERVICE("svc22_eiyoukanri")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1220106", recPROVIDERSERVICE("svc22_eiyoukanri"))
                End If
            End If
        
            '���Ə��T�[�r�XID��1��������
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'�Z�������×{���i�a�@�j�̃f�[�^�ڍs
        If recPROVIDERSERVICE("svc23_rh_flg") = 2 Then
            '���Ə��T�[�r�X�ڍs
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "12311", recPROVIDERSERVICE("reduce23"))
       
            '�l���z�u�敪���ڍs
            If Not IsNull(recPROVIDERSERVICE("svc23_rh_staff")) Then
                 Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230102", recPROVIDERSERVICE("svc23_rh_staff"))
            End If
            '�×{������ڍs
            If Not IsNull(recPROVIDERSERVICE("svc23_rh_env")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230104", recPROVIDERSERVICE("svc23_rh_env"))
            End If
            '��t�̔z�u����ڍs
            If Not IsNull(recPROVIDERSERVICE("svc23_rh_dr")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230105", recPROVIDERSERVICE("svc23_rh_dr"))
            End If
            '���}�̐����ڍs
            If Not IsNull(recPROVIDERSERVICE("svc23_rh_ws")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230106", recPROVIDERSERVICE("svc23_rh_ws"))
            End If
        
        
            'Ver2.0�̎�
            If GetDBVersion = VER20 Then
               '�{�݋敪���ڍs
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230101", "1")
                '��ԋΖ���������ڍs
                '�ڍs���f�[�^���u5�v�̎�
                If Not IsNull(recPROVIDERSERVICE("svc23_rh_nw")) Then
                    If recPROVIDERSERVICE("svc23_rh_nw") = 5 Then
                        '�Ȃɂ����Ȃ�
                    '�ڍs���f�[�^���u6�v�̎�
                    ElseIf recPROVIDERSERVICE("svc23_rh_nw") = 6 Then
                        '�u5�v���ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230103", "5")
                    '��L�ȊO
                    Else
                        '��ԋΖ���������ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230103", recPROVIDERSERVICE("svc23_rh_nw"))
                    End If
                End If
            'Ver3.5�̎�
            ElseIf GetDBVersion = VER35 Then
                '�{�݋敪���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc23_rh_unit")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230101", recPROVIDERSERVICE("svc23_rh_unit"))
                End If
                '��ԋΖ���������ڍs
                If Not IsNull(recPROVIDERSERVICE("svc23_rh_nw")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230103", recPROVIDERSERVICE("svc23_rh_nw"))
                End If
                '�h�{�Ǘ��̐����ڍs
                If Not IsNull(recPROVIDERSERVICE("svc23_rh_eiyoukanri")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230107", recPROVIDERSERVICE("svc23_rh_eiyoukanri"))
                End If
            End If
        
            '���Ə��T�[�r�XID��1��������
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'�Z�������×{���i�f�Ï��j�̃f�[�^�ڍs
        If recPROVIDERSERVICE("svc23_rc_flg") = 2 Then
            '���Ə��T�[�r�X�ڍs
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "12312", recPROVIDERSERVICE("reduce23"))
       
            '�l���z�u�敪���ڍs
            If Not IsNull(recPROVIDERSERVICE("svc23_rc_staff")) Then
                 Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230202", recPROVIDERSERVICE("svc23_rc_staff"))
            End If
            '�×{������ڍs
            If Not IsNull(recPROVIDERSERVICE("svc23_rc_env")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230203", recPROVIDERSERVICE("svc23_rc_env"))
            End If
            '���}�̐����ڍs
            If Not IsNull(recPROVIDERSERVICE("svc23_rc_ws")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230204", recPROVIDERSERVICE("svc23_rc_ws"))
            End If
        
            'Ver2.0�̎�
            If GetDBVersion = VER20 Then
               '�{�݋敪���ڍs
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230201", "1")
            'Ver3.5�̎�
            ElseIf GetDBVersion = VER35 Then
                '�{�݋敪���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc23_rc_unit")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230201", recPROVIDERSERVICE("svc23_rc_unit"))
                End If

                '�h�{�Ǘ��̐����ڍs
                If Not IsNull(recPROVIDERSERVICE("svc23_rc_eiyoukanri")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230205", recPROVIDERSERVICE("svc23_rc_eiyoukanri"))
                End If
            End If
        
            '���Ə��T�[�r�XID��1��������
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'�Z�������×{���i�F�m�ǁj�̃f�[�^�ڍs
        If recPROVIDERSERVICE("svc23_dh_flg") = 2 Then
            '���Ə��T�[�r�X�ڍs
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "12313", recPROVIDERSERVICE("reduce23"))
       
            '�l���z�u�敪���ڍs
'            If Not IsNull(recPROVIDERSERVICE("svc23_dh_staff")) Then
'                 Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230302", recPROVIDERSERVICE("svc23_dh_staff"))
'            End If
            '���}�̐����ڍs
            If Not IsNull(recPROVIDERSERVICE("svc23_dh_ws")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230303", recPROVIDERSERVICE("svc23_dh_ws"))
            End If
        
            'Ver2.0�̎�
            If GetDBVersion = VER20 Then
               '�{�݋敪���ڍs
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230301", "1")
            'Ver3.5�̎�
            ElseIf GetDBVersion = VER35 Then
                '�{�݋敪���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc23_dh_unit")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230301", recPROVIDERSERVICE("svc23_dh_unit"))
                End If

                '�h�{�Ǘ��̐����ڍs
                If Not IsNull(recPROVIDERSERVICE("svc23_dh_eiyoukanri")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230304", recPROVIDERSERVICE("svc23_dh_eiyoukanri"))
                End If
            End If
        
            '���Ə��T�[�r�XID��1��������
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'�Z�������×{���i��K���^�j�̃f�[�^�ڍs
        If recPROVIDERSERVICE("svc23_sc_flg") = 2 Then
            '���Ə��T�[�r�X�ڍs
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "12314", recPROVIDERSERVICE("reduce23"))
       
            '���}�̐����ڍs
            If Not IsNull(recPROVIDERSERVICE("svc23_sc_ws")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230401", recPROVIDERSERVICE("svc23_sc_ws"))
            End If
            
            'Ver3.5�̎�
            If GetDBVersion = VER35 Then
                '�h�{�Ǘ��̐����ڍs
                If Not IsNull(recPROVIDERSERVICE("svc23_sc_eiyoukanri")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230402", recPROVIDERSERVICE("svc23_sc_eiyoukanri"))
                End If
            End If
        
            '���Ə��T�[�r�XID��1��������
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
    
    
'==============================================================================================================================
'����×{�Ǘ��w���̃f�[�^�ڍs
        If recPROVIDERSERVICE("svc31_flg") = 2 Then
            '���Ə��T�[�r�X�ڍs
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "13111", recPROVIDERSERVICE("reduce31"))
   
            '���Ə��T�[�r�XID��1��������
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
    
    
'==============================================================================================================================
'������x���̃f�[�^�ڍs
        If recPROVIDERSERVICE("svc43_flg") = 2 Then
            '���Ə��T�[�r�X�ڍs
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "14311", recPROVIDERSERVICE("reduce43"))
   
            '���Ə��T�[�r�XID��1��������
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
    
    
'==================================================================================================================================
'Ver3.5
If GetDBVersion = VER35 Then
    
    '==============================================================================================================================
    '�F�m�ǑΉ��^�����������̃f�[�^�ڍs
            If recPROVIDERSERVICE("svc32_flg") = 2 Then
                '���Ə��T�[�r�X�ڍs
                Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
                "13211", recPROVIDERSERVICE("reduce32"))
                
                '�l�����Z���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc32_shortage")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1320102", recPROVIDERSERVICE("svc32_shortage"))
                End If
            
                '���Ə��T�[�r�XID��1��������
                intProviderServiceID = intProviderServiceID + 1
            End If
    '==============================================================================================================================
    
        
    '==============================================================================================================================
    '����{�ݓ����Ґ������̃f�[�^�ڍs
            If recPROVIDERSERVICE("svc33_flg") = 2 Then
                '���Ə��T�[�r�X�ڍs
                Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
                "13311", recPROVIDERSERVICE("reduce33"))
                
                '�ʋ@�\�P���w���̐����ڍs
                If Not IsNull(recPROVIDERSERVICE("svc33_training")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1330101", recPROVIDERSERVICE("svc33_training"))
                End If
                '�l�����Z���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc33_shortage")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1330102", recPROVIDERSERVICE("svc33_shortage"))
                End If
            
                '���Ə��T�[�r�XID��1��������
                intProviderServiceID = intProviderServiceID + 1
            End If
    '==============================================================================================================================
    
    
    '==============================================================================================================================
    '���V�l�����{�݂̃f�[�^�ڍs
            If recPROVIDERSERVICE("svc51_flg") = 2 Then
                '���Ə��T�[�r�X�ڍs
                Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
                "15111", recPROVIDERSERVICE("reduce51"))
                
                '�{�݋敪���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc51_est")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510101", recPROVIDERSERVICE("svc51_est"))
                End If
                '��ԋΖ���������ڍs
                If Not IsNull(recPROVIDERSERVICE("svc51_nw")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510102", recPROVIDERSERVICE("svc51_nw"))
                End If
                '�ʋ@�\�P���w���̐����ڍs
                If Not IsNull(recPROVIDERSERVICE("svc51_training")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510103", recPROVIDERSERVICE("svc51_training"))
                End If
                '��ΐ�]��t�z�u���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc51_dr")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510104", recPROVIDERSERVICE("svc51_dr"))
                End If
                '���_�Ȉ�t����I�×{�w�����ڍs
                If Not IsNull(recPROVIDERSERVICE("svc51_mental")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510105", recPROVIDERSERVICE("svc51_mental"))
                End If
                '��Q�Ґ����x���̐����ڍs
                If Not IsNull(recPROVIDERSERVICE("svc51_hc")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510106", recPROVIDERSERVICE("svc51_hc"))
                End If
                '�h�{�Ǘ��̐����ڍs
                '3�ȉ��̎�
                If Not IsNull(recPROVIDERSERVICE("svc51_eiyoukanri")) Then
                    If recPROVIDERSERVICE("svc51_eiyoukanri") <= 3 Then
                        '�h�{�Ǘ��̐����ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510108", recPROVIDERSERVICE("svc51_eiyoukanri"))
                    '4�̎�
                    ElseIf recPROVIDERSERVICE("svc51_eiyoukanri") = 4 Then
                        '�ڍs���̃f�[�^���u1�v�ɕϊ����ăf�[�^���ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510108", "1")
                        '�h�{�}�l�W�����g�Ɂu2�v��o�^
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510109", "2")
                    '5�̎�
                    ElseIf recPROVIDERSERVICE("svc51_eiyoukanri") = 5 Then
                        '�ڍs���̃f�[�^���u2�v�ɕϊ����ăf�[�^���ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510108", "2")
                        '�h�{�}�l�W�����g�Ɂu2�v��o�^
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510109", "2")
                    '6�̎�
                    ElseIf recPROVIDERSERVICE("svc51_eiyoukanri") = 6 Then
                        '�ڍs���̃f�[�^���u3�v�ɕϊ����ăf�[�^���ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510108", "3")
                        '�h�{�}�l�W�����g�Ɂu2�v��o�^
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510109", "2")
                    End If
                End If
                '�l�����Z���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc51_shortage")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510112", recPROVIDERSERVICE("svc51_shortage"))
                End If
                '�Љ���y���[�u
                '�ڍs���f�[�^��2�̎�
                If Not IsNull(recPROVIDERSERVICE("svc51_shafuku")) Then
                    If recPROVIDERSERVICE("svc51_shafuku") = 2 Then
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1", "2")
                    End If
                End If
            
                '���Ə��T�[�r�XID��1��������
                intProviderServiceID = intProviderServiceID + 1
            End If
    '==============================================================================================================================
    
    
    '==============================================================================================================================
    '���V�l�ی��{�݂̃f�[�^�ڍs
            If recPROVIDERSERVICE("svc52_flg") = 2 Then
                '���Ə��T�[�r�X�ڍs
                Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
                "15211", recPROVIDERSERVICE("reduce52"))
    
                '�{�݋敪���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc52_unit")) Then
                    If recPROVIDERSERVICE("svc52_unit") = 2 Then
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520101", "3")
                    Else
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520101", "1")
                    End If
                End If
                '��ԋΖ���������ڍs
                If Not IsNull(recPROVIDERSERVICE("svc52_nw")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520102", recPROVIDERSERVICE("svc52_nw"))
                End If
                '�h�{�Ǘ��̐����ڍs
                If Not IsNull(recPROVIDERSERVICE("svc52_eiyoukanri")) Then
                    '3�ȉ��̎�
                    If recPROVIDERSERVICE("svc52_eiyoukanri") <= 3 Then
                        '�h�{�Ǘ��̐����ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520105", recPROVIDERSERVICE("svc52_eiyoukanri"))
                    '4�̎�
                    ElseIf recPROVIDERSERVICE("svc52_eiyoukanri") = 4 Then
                        '�ڍs���̃f�[�^���u1�v�ɕϊ����ăf�[�^���ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520105", "1")
                        '�h�{�}�l�W�����g�Ɂu2�v��o�^
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520106", "2")
                    '5�̎�
                    ElseIf recPROVIDERSERVICE("svc52_eiyoukanri") = 5 Then
                        '�ڍs���̃f�[�^���u2�v�ɕϊ����ăf�[�^���ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520105", "2")
                        '�h�{�}�l�W�����g�Ɂu2�v��o�^
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520106", "2")
                    '6�̎�
                    ElseIf recPROVIDERSERVICE("svc52_eiyoukanri") = 6 Then
                        '�ڍs���̃f�[�^���u3�v�ɕϊ����ăf�[�^���ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520105", "3")
                        '�h�{�}�l�W�����g�Ɂu2�v��o�^
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520106", "2")
                    End If
                End If
                '�l�����Z���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc52_shortage")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520109", recPROVIDERSERVICE("svc52_shortage"))
                End If
                
                '���Ə��T�[�r�XID��1��������
                intProviderServiceID = intProviderServiceID + 1
            End If
    '==============================================================================================================================
    
        
    '==============================================================================================================================
    '���×{�^��Î{�݁i�a�@�j�̃f�[�^�ڍs
            If recPROVIDERSERVICE("svc53_1_flg") = 2 Then
                '���Ə��T�[�r�X�ڍs
                Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
                "15311", recPROVIDERSERVICE("reduce53"))
    
                '�{�݋敪���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc53_1_unit")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530101", recPROVIDERSERVICE("svc53_1_unit"))
                End If
                '�l���z�u�敪���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc53_1_staff")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530102", recPROVIDERSERVICE("svc53_1_staff"))
                End If
                '��ԋΖ���������ڍs
                If Not IsNull(recPROVIDERSERVICE("svc53_1_nw")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530103", recPROVIDERSERVICE("svc53_1_nw"))
                End If
                '�×{������ڍs
                If Not IsNull(recPROVIDERSERVICE("svc53_1_env")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530104", recPROVIDERSERVICE("svc53_1_env"))
                End If
                '��t�̔z�u����ڍs
                If Not IsNull(recPROVIDERSERVICE("svc53_1_dr")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530105", recPROVIDERSERVICE("svc53_1_dr"))
                End If
                '�h�{�Ǘ��̐����ڍs
                If Not IsNull(recPROVIDERSERVICE("svc53_1_eiyoukanri")) Then
                    '3�ȉ��̎�
                    If recPROVIDERSERVICE("svc53_1_eiyoukanri") <= 3 Then
                        '�h�{�Ǘ��̐����ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530106", recPROVIDERSERVICE("svc53_1_eiyoukanri"))
                    '4�̎�
                    ElseIf recPROVIDERSERVICE("svc53_1_eiyoukanri") = 4 Then
                        '�ڍs���̃f�[�^���u1�v�ɕϊ����ăf�[�^���ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530106", "1")
                        '�h�{�}�l�W�����g�Ɂu2�v��o�^
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530107", "2")
                    '5�̎�
                    ElseIf recPROVIDERSERVICE("svc53_1_eiyoukanri") = 5 Then
                        '�ڍs���̃f�[�^���u2�v�ɕϊ����ăf�[�^���ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530106", "2")
                        '�h�{�}�l�W�����g�Ɂu2�v��o�^
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530107", "2")
                    '6�̎�
                    ElseIf recPROVIDERSERVICE("svc53_1_eiyoukanri") = 6 Then
                        '�ڍs���̃f�[�^���u3�v�ɕϊ����ăf�[�^���ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530106", "3")
                        '�h�{�}�l�W�����g�Ɂu2�v��o�^
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530107", "2")
                    End If
                End If
                '�l�����Z���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc53_1_shortage")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530110", recPROVIDERSERVICE("svc53_1_shortage"))
                End If

                '����f�Ô�̃f�[�^�ڍs
                If Not IsNull(recPROVIDERSERVICE("svc53_1_sp_tr")) Then
                    '�d�ǔ畆��ᇎw���Ǘ��̃f�[�^���ڍs
                    '�ڍs���f�[�^�̍�����1�������f�[�^�ڍs
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "3010101", Left(recPROVIDERSERVICE("svc53_1_sp_tr"), 1))
                    '��܊Ǘ��w��
                    '�ڍs���f�[�^�̉E����1�������f�[�^�ڍs
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "3010102", Right(recPROVIDERSERVICE("svc53_1_sp_tr"), 1))
                End If
                
                '���Ə��T�[�r�XID��1��������
                intProviderServiceID = intProviderServiceID + 1
            End If
    '==============================================================================================================================
    
    
    '==============================================================================================================================
    '���×{�^��Î{�݁i�f�Ï��j�̃f�[�^�ڍs
            If recPROVIDERSERVICE("svc53_2_flg") = 2 Then
                '���Ə��T�[�r�X�ڍs
                Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
                "15312", recPROVIDERSERVICE("reduce53"))
    
                '�{�݋敪���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc53_2_unit")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530201", recPROVIDERSERVICE("svc53_2_unit"))
                End If
                '�l���z�u�敪���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc53_2_staff")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530202", recPROVIDERSERVICE("svc53_2_staff"))
                End If
                '�×{������ڍs
                If Not IsNull(recPROVIDERSERVICE("svc53_2_env")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530203", recPROVIDERSERVICE("svc53_2_env"))
                End If
                '�h�{�Ǘ��̐����ڍs
                If Not IsNull(recPROVIDERSERVICE("svc53_2_eiyoukanri")) Then
                    '3�ȉ��̎�
                    If recPROVIDERSERVICE("svc53_2_eiyoukanri") <= 3 Then
                        '�h�{�Ǘ��̐����ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530204", recPROVIDERSERVICE("svc53_2_eiyoukanri"))
                    '4�̎�
                    ElseIf recPROVIDERSERVICE("svc53_2_eiyoukanri") = 4 Then
                        '�ڍs���̃f�[�^���u1�v�ɕϊ����ăf�[�^���ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530204", "1")
                        '�h�{�}�l�W�����g�Ɂu2�v��o�^
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530205", "2")
                    '5�̎�
                    ElseIf recPROVIDERSERVICE("svc53_2_eiyoukanri") = 5 Then
                        '�ڍs���̃f�[�^���u2�v�ɕϊ����ăf�[�^���ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530204", "2")
                        '�h�{�}�l�W�����g�Ɂu2�v��o�^
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530205", "2")
                    '6�̎�
                    ElseIf recPROVIDERSERVICE("svc53_2_eiyoukanri") = 6 Then
                        '�ڍs���̃f�[�^���u3�v�ɕϊ����ăf�[�^���ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530204", "3")
                        '�h�{�}�l�W�����g�Ɂu2�v��o�^
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530205", "2")
                    End If
                End If
                '����f�Ô�̃f�[�^�ڍs
                If Not IsNull(recPROVIDERSERVICE("svc53_2_sp_tr")) Then
                    '�d�ǔ畆��ᇎw���Ǘ��̃f�[�^���ڍs
                    '�ڍs���f�[�^�̍�����1�������f�[�^�ڍs
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "3010101", Left(recPROVIDERSERVICE("svc53_2_sp_tr"), 1))
                    '��܊Ǘ��w��
                    '�ڍs���f�[�^�̉E����1�������f�[�^�ڍs
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "3010102", Right(recPROVIDERSERVICE("svc53_2_sp_tr"), 1))
                End If
                
                '���Ə��T�[�r�XID��1��������
                intProviderServiceID = intProviderServiceID + 1
            End If
    '==============================================================================================================================
    
    
    '==============================================================================================================================
    '���×{�^��Î{�݁i�F�m�ǎ����^�j�̃f�[�^�ڍs
            If recPROVIDERSERVICE("svc53_3_flg") = 2 Then
                '���Ə��T�[�r�X�ڍs
                Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
                "15313", recPROVIDERSERVICE("reduce53"))
    
                '�{�݋敪���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc53_3_unit")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530301", recPROVIDERSERVICE("svc53_3_unit"))
                End If
                '�l���z�u�敪���ڍs
'                If Not IsNull(recPROVIDERSERVICE("svc53_3_staff")) Then
'                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530302", recPROVIDERSERVICE("svc53_3_staff"))
'                End If
                '3�ȉ��̎�
                If Not IsNull(recPROVIDERSERVICE("svc53_3_eiyoukanri")) Then
                    If recPROVIDERSERVICE("svc53_3_eiyoukanri") <= 3 Then
                        '�h�{�Ǘ��̐����ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530303", recPROVIDERSERVICE("svc53_3_eiyoukanri"))
                    '4�̎�
                    ElseIf recPROVIDERSERVICE("svc53_3_eiyoukanri") = 4 Then
                        '�ڍs���̃f�[�^���u1�v�ɕϊ����ăf�[�^���ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530303", "1")
                        '�h�{�}�l�W�����g�Ɂu2�v��o�^
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530304", "2")
                    '5�̎�
                    ElseIf recPROVIDERSERVICE("svc53_3_eiyoukanri") = 5 Then
                        '�ڍs���̃f�[�^���u2�v�ɕϊ����ăf�[�^���ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530303", "2")
                        '�h�{�}�l�W�����g�Ɂu2�v��o�^
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530304", "2")
                    '6�̎�
                    ElseIf recPROVIDERSERVICE("svc53_3_eiyoukanri") = 6 Then
                        '�ڍs���̃f�[�^���u3�v�ɕϊ����ăf�[�^���ڍs
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530303", "3")
                        '�h�{�}�l�W�����g�Ɂu2�v��o�^
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530304", "2")
                    End If
                End If
                '�l�����Z���ڍs
                If Not IsNull(recPROVIDERSERVICE("svc53_3_shortage")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530307", recPROVIDERSERVICE("svc53_3_shortage"))
                End If
                
                '���Ə��T�[�r�XID��1��������
                intProviderServiceID = intProviderServiceID + 1
            End If
    '==============================================================================================================================
End If
'==================================================================================================================================
        recPROVIDERSERVICE.MoveNext
    Loop
    
    Set recPROVIDERSERVICENEW = FDBExecuteRecordSet("SELECT * FROM PROVIDER_SERVICE", adOpenForwardOnly, adLockReadOnly)
    i = 0: j = 0
    Do Until recPROVIDERSERVICENEW.EOF
        '���ڂ̃��[�v�����̂Ƃ��A���Ə��ԍ���old����ɐݒ肷��B
        If i = 0 And j = 0 Then varProviderID_old = ""
        '���Ə��ԍ�old�Ǝ擾�������Ə��ԍ�����v�����A���ڈȍ~�̃��[�v�����̂Ƃ�
        If recPROVIDERSERVICENEW("PROVIDER_ID") <> varProviderID_old And varProviderID_old <> "" Then
            i = i + 1
            '���Ə�ID�́uSystemKindDetail�v�z��Ɂi���Ə�ID�ASystemKindDetail�j���i�[
            varProviderIDToSystemKindDetail(i, j) = recPROVIDERSERVICENEW("PROVIDER_ID") & "," & recPROVIDERSERVICENEW("SYSTEM_SERVICE_KIND_DETAIL")
        Else
            '���Ə�ID�́uSystemKindDetail�v�z��Ɂi���Ə�ID�ASystemKindDetail�j���i�[
            varProviderIDToSystemKindDetail(i, j) = recPROVIDERSERVICENEW("PROVIDER_ID") & "," & recPROVIDERSERVICENEW("SYSTEM_SERVICE_KIND_DETAIL")
        End If
        '���Ə��ԍ���old�l�̐ݒ�
        varProviderID_old = recPROVIDERSERVICENEW("PROVIDER_ID")
        '�z��Ɏ��Ə��ԍ���ݒ�
        strProviderID(i) = recPROVIDERSERVICENEW("PROVIDER_ID")
        j = j + 1
        
        recPROVIDERSERVICENEW.MoveNext
    Loop

    '���Ə��T�[�r�X�̃f�[�^�̌����擾
    Set recPROVIDERSERVIDEMAX = FDBExecuteRecordSet("SELECT COUNT(*) FROM PROVIDER_SERVICE", adOpenForwardOnly, adLockReadOnly)
    '���Ə��T�[�r�X�̌������[�v����
    For j = 0 To recPROVIDERSERVIDEMAX(0) - 1
        For intLogicalAdd = 0 To i
            If varProviderIDToSystemKindDetail(intLogicalAdd, j) <> "" Then
                varProviderID = Split(varProviderIDToSystemKindDetail(intLogicalAdd, j), ",")
                Set recMSERVICE = FDBExecuteRecordSet("SELECT * FROM M_SERVICE WHERE SYSTEM_SERVICE_KIND_DETAIL=" & varProviderID(1))
                '�_���a
                LogicalAdd(intLogicalAdd) = recMSERVICE("BUSINESS_TYPE") Or LogicalAdd(intLogicalAdd)
            End If
        Next intLogicalAdd
    Next j
    
    Set recMMENU = FDBExecuteRecordSet("SELECT * FROM M_MENU", adOpenForwardOnly, adLockReadOnly)
    
    '�_���ς𓱂��o��
    intMMenu = 0
    Do Until recMMENU.EOF
        For i = 0 To intLogicalAdd - 1
            LogicalProduct(i, intMMenu) = recMMENU("BUSINESS_TYPE") And LogicalAdd(i)
            intMenuID(i, intMMenu) = recMMENU("MENU_ID")
        Next i
        intMMenu = intMMenu + 1
        recMMENU.MoveNext
    Loop
    
    '���Ə����j���[�Ƀf�[�^���ڍs
    For i = 0 To intMMenu - 1
        For j = 0 To intLogicalAdd - 1
            If LogicalProduct(j, i) = 0 Then
                Call ConvPROVIDERMENU(strProviderID(j), intMenuID(j, i), 0)
            Else
                Call ConvPROVIDERMENU(strProviderID(j), intMenuID(j, i), 1)
            End If
        Next j
    Next i
    
    Exit Sub

Err_Connection:

    MsgBox "�f�[�^�̈ڍs�Ɏ��s���܂����B" & vbNewLine & "�\���󂠂�܂��񂪁A�f�[�^�̈ڍs���͂��߂����蒼���Ă��������B" _
    , vbInformation + vbOKOnly, "�f�[�^�ڍs���s"
    
    End

End Sub

Function ReplaceFDBFile(ByVal pstrFilePath As String) As Boolean
'============================================================================================
'�w�肳�ꂽFDB�t�@�C�����f�[�^�̓����Ă��Ȃ�FDB�t�@�C���ƒu������
'============================================================================================
Dim strPath As String
Dim strFilename As String
Dim strZeroFile As String

    ReplaceFDBFile = False

    strZeroFile = App.Path & "\CONVERT.DAT"

    '�R�s�[���̃t�@�C�������邩�`�F�b�N
    If Dir(strZeroFile) = "" Then
        Call LogWrite(Error, "CONVERT.DAT��������܂���B")
        Exit Function
    End If

    On Error GoTo ERR_SECTION
        strPath = Left$(pstrFilePath, InStrRev(pstrFilePath, "\"))
        strFilename = Dir(pstrFilePath)
        strFilename = Left$(strFilename, InStrRev(strFilename, ".") - 1)

        '�t�@�C���̃o�b�N�A�b�v���쐬
        Name pstrFilePath As strPath & GetBackupFileName(strPath, 0)
        '�󔒂̃f�[�^�x�[�X�t�@�C�����R�s�[
        Call FileCopy(strZeroFile, pstrFilePath)

        ReplaceFDBFile = True
    On Error GoTo 0

ERR_SECTION:
End Function

Function GetBackupFileName(pstrPath As String, pintCount) As String
'============================================================================================
'�ޔ�p�̃t�@�C�������擾����
'============================================================================================
Dim strFilaName As String

    If pintCount = 0 Then
        strFilaName = "convert.old"
    Else
        strFilaName = "convert" & CStr(pintCount) & ".old"
    End If

    '�����t�@�C�������݂���
    If Dir(pstrPath & strFilaName) <> "" Then
        GetBackupFileName = GetBackupFileName(pstrPath, pintCount + 1)
    Else
        GetBackupFileName = strFilaName
    End If

End Function

