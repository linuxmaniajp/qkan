Attribute VB_Name = "basConvCommon"
Option Explicit

Public Sub ConvHOMONKANGORESULT()
'============================================================================================
'訪問看護報告書情報移行（全共通）
'============================================================================================
Dim recHOMONKANGORESULT As Object
Dim recHOMONKANGORESULT_New As Object
Dim strSQL As String
Dim strSQLCalender As String
Dim i As Integer

    'エラー処理
    On Error GoTo Err_Connection
    

    '訪問看護報告書情報テーブルの取得
    Set recHOMONKANGORESULT = MDBExecuteRecordSet("SELECT * FROM f07 order by ID DESC", adOpenForwardOnly, adLockReadOnly)

    '訪問看護報告書情報数分処理を回す
    Do Until recHOMONKANGORESULT.EOF
        '5.0のデータの有無をチェック
        Set recHOMONKANGORESULT_New = FDBExecuteRecordSet("SELECT * FROM HOMONKANGO_RESULT WHERE " & _
        "PATIENT_ID=" & recHOMONKANGORESULT("pat_id") & " AND TARGET_DATE= " & "'" & recHOMONKANGORESULT("d02") & "'", _
        adOpenForwardOnly, adLockReadOnly)
    
        If recHOMONKANGORESULT_New.EOF Then
            '訪問看護報告書情報テーブルを移行
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
            '利用者IDのデータ移行
            strSQL = strSQL & recHOMONKANGORESULT("pat_id") & ","
            '対象年月のデータ移行
            strSQL = strSQL & "'" & recHOMONKANGORESULT("d02") & "',"
            '要介護度のデータ移行
            'NULLの時は0を移行
            If IsNull(recHOMONKANGORESULT("o10")) Then
                strSQL = strSQL & "0,"
            'NULLでない時
            Else
                '移行元データが0の時は1（自立）に変更し、データ移行
                If recHOMONKANGORESULT("o10") = 0 Then
                    strSQL = strSQL & "1,"
                '移行元データが1の時は11（要支援）に変更し、データ移行
                ElseIf recHOMONKANGORESULT("o10") = 1 Then
                    strSQL = strSQL & "11,"
                '移行元データが2の時は21（要介護1）に変更し、データ移行
                ElseIf recHOMONKANGORESULT("o10") = 2 Then
                    strSQL = strSQL & "21,"
                '移行元データが3の時は22（要介護2）に変更し、データ移行
                ElseIf recHOMONKANGORESULT("o10") = 3 Then
                    strSQL = strSQL & "22,"
                '移行元データが4の時は23（要介護3）に変更し、データ移行
                ElseIf recHOMONKANGORESULT("o10") = 4 Then
                    strSQL = strSQL & "23,"
                '移行元データが5の時は24（要介護4）に変更し、データ移行
                ElseIf recHOMONKANGORESULT("o10") = 5 Then
                    strSQL = strSQL & "24,"
                '移行元データが6の時は25（要介護5）に変更し、データ移行
                ElseIf recHOMONKANGORESULT("o10") = 6 Then
                    strSQL = strSQL & "25,"
                End If
            End If
            '医師氏名のデータを移行
            'NULLの時
            If IsNull(recHOMONKANGORESULT("t04")) Then
                strSQL = strSQL & "'',"
            Else
                '移行元のデータを移行（シングルクォートを置換）
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGORESULT("t04"), 32), "'", "''") & "',"
            End If
            '作成年月日のデータを移行
            'NULLの時は、NULL文字を移行
            If IsNull(recHOMONKANGORESULT("d01")) Then
                strSQL = strSQL & "NULL" & ","
            'NULLでない時は、作成年月日のデータを移行
            Else
                strSQL = strSQL & "'" & recHOMONKANGORESULT("d01") & "',"
            End If
            '事業所名称のデータを移行
            'NULLのとき
            If IsNull(recHOMONKANGORESULT("t03")) Then
                strSQL = strSQL & "'',"
            Else
                '移行元のデータを移行（シングルクォートを置換）
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGORESULT("t03"), 64), "'", "''") & "',"
            End If
            '管理者氏名のデータを移行
            'NULLのとき
            If IsNull(recHOMONKANGORESULT("t02")) Then
                strSQL = strSQL & "'',"
            Else
                '移行元のデータを移行（シングルクォートを置換）
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGORESULT("t02"), 22), "'", "''") & "',"
            End If
            '病状の経過のデータを移行
            'NULLのとき
            If IsNull(recHOMONKANGORESULT("t05")) Then
                strSQL = strSQL & "'',"
            Else
                '移行元のデータを移行（シングルクォートを置換）
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGORESULT("t05"), 294), "'", "''") & "',"
            End If
            '看護・リハビリテーションのデータを移行
            'NULLのとき
            If IsNull(recHOMONKANGORESULT("t06")) Then
                strSQL = strSQL & "'',"
            Else
                '移行元のデータを移行（シングルクォートを置換）
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGORESULT("t06"), 378), "'", "''") & "',"
            End If
            '家庭での療養・看護の状況のデータを移行
            'NULLのとき
            If IsNull(recHOMONKANGORESULT("t07")) Then
                 strSQL = strSQL & "'',"
            Else
                '移行元のデータを移行（シングルクォートを置換）
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGORESULT("t07"), 336), "'", "''") & "',"
            End If
            '特記すべき事項のデータを移行
            'NULLのとき
            If IsNull(recHOMONKANGORESULT("t08")) Then
                strSQL = strSQL & "'',"
            Else
                '移行元のデータを移行（シングルクォートを置換）
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGORESULT("t08"), 240), "'", "''") & "',"
            End If
            '最終更新日にシステム日付を登録
            strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
            strSQL = strSQL & ")"
            Call FDBExecuteSQL(strSQL)
            
            '訪問看護報告書（カレンダー）情報テーブルを移行
            '作成年月日の末日分ループ処理を行う
            For i = 1 To Day(DateAdd("d", -1, DateAdd("m", 1, recHOMONKANGORESULT("d02"))))
                strSQLCalender = ""
                strSQLCalender = strSQLCalender & "INSERT INTO HOMONKANGO_RESULT_CALENDAR ("
                strSQLCalender = strSQLCalender & "PATIENT_ID,"
                strSQLCalender = strSQLCalender & "VISIT_DATE,"
                strSQLCalender = strSQLCalender & "VISIT_VALUE,"
                strSQLCalender = strSQLCalender & "LAST_TIME"
                strSQLCalender = strSQLCalender & ")"
                
                strSQLCalender = strSQLCalender & " VALUES ("
                '利用者IDのデータを移行する
                strSQLCalender = strSQLCalender & recHOMONKANGORESULT("pat_id") & ","
                '訪問年月のデータを移行する
                '作成年月日より年月を取得し、ループのカウントを日とし、日付型でフォーマットを行う
                strSQLCalender = strSQLCalender & "'" & Format(Format(recHOMONKANGORESULT("d02"), "yyyy/mm") & "/" & i, "yyyy/mm/dd") & "',"
                '訪問実績のデータを移行する
                '移行元データが0の時、1に変換し、データを移行
                If Mid(recHOMONKANGORESULT("b00"), i, 1) = 0 Then
                    strSQLCalender = strSQLCalender & "1,"
                '移行元データが1と6の時、2に変換し、データを移行
                ElseIf Mid(recHOMONKANGORESULT("b00"), i, 1) = 1 Or Mid(recHOMONKANGORESULT("b00"), i, 1) = 6 Then
                    strSQLCalender = strSQLCalender & "2,"
                '移行元データが2と7の時、3に変換し、データを移行
                ElseIf Mid(recHOMONKANGORESULT("b00"), i, 1) = 2 Or Mid(recHOMONKANGORESULT("b00"), i, 1) = 7 Then
                    strSQLCalender = strSQLCalender & "3,"
                '移行元データが3の時、5に変換し、データを移行
                ElseIf Mid(recHOMONKANGORESULT("b00"), i, 1) = 3 Then
                    strSQLCalender = strSQLCalender & "5,"
                '移行元データが5の時、4に変換し、データを移行
                ElseIf Mid(recHOMONKANGORESULT("b00"), i, 1) = 5 Then
                    strSQLCalender = strSQLCalender & "4,"
                End If
                '最終更新日にシステム日付を登録
                strSQLCalender = strSQLCalender & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
                strSQLCalender = strSQLCalender & ")"
                
                Call FDBExecuteSQL(strSQLCalender)
            Next i
            '作成年月日の次月の末日分ループ処理を行う
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
'                '利用者IDのデータを移行する
'                strSQLCalender = strSQLCalender & recHOMONKANGORESULT("pat_id") & ","
'                '訪問年月のデータを移行する
'                '作成年月日の年月をDateAdd関数により次月にし、ループのカウントを日とし、日付型でフォーマットを行う
'                strSQLCalender = strSQLCalender & "'" & Format(Format(DateAdd("m", 1, recHOMONKANGORESULT("d02")), "yyyy/mm") & "/" & i, "yyyy/mm/dd") & "',"
'                '訪問実績のデータを移行する
'                '移行元データが0の時、1に変換し、データを移行
'                If Mid(recHOMONKANGORESULT("b01"), i, 1) = 0 Then
'                    strSQLCalender = strSQLCalender & "1,"
'                '移行元データが1と6の時、2に変換し、データを移行
'                ElseIf Mid(recHOMONKANGORESULT("b01"), i, 1) = 1 Or Mid(recHOMONKANGORESULT("b01"), i, 1) = 6 Then
'                    strSQLCalender = strSQLCalender & "2,"
'                '移行元データが2と7の時、3に変換し、データを移行
'                ElseIf Mid(recHOMONKANGORESULT("b01"), i, 1) = 2 Or Mid(recHOMONKANGORESULT("b01"), i, 1) = 7 Then
'                    strSQLCalender = strSQLCalender & "3,"
'                '移行元データが3の時、5に変換し、データを移行
'                ElseIf Mid(recHOMONKANGORESULT("b01"), i, 1) = 3 Then
'                    strSQLCalender = strSQLCalender & "5,"
'                '移行元データが5の時、4に変換し、データを移行
'                ElseIf Mid(recHOMONKANGORESULT("b01"), i, 1) = 5 Then
'                    strSQLCalender = strSQLCalender & "4,"
'                End If
'                '最終更新日にシステム日付を登録
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

    MsgBox "データの移行に失敗しました。" & vbNewLine & "申し訳ありませんが、データの移行をはじめからやり直してください。" _
    , vbInformation + vbOKOnly, "データ移行失敗"
    
    End

End Sub

Public Sub ConvHOMONKANGOPLAN()
'============================================================================================
'訪問看護計画書情報移行（全共通）
'============================================================================================
Dim recHOMONKANGOPLAN As Object
Dim recHOMONKANGOPLAN_New As Object
Dim recHOMONKANGOPLANNOTE As Object
Dim strSQL As String
Dim strSQLNote As String
Dim intNoteID As Integer
'利用者番号のold格納変数
Dim intPatientID_old As Integer

    '枝番の初期化
    intNoteID = 1
    
    'エラー処理
    On Error GoTo Err_Connection

    '訪問看護計画書情報テーブルの取得
    Set recHOMONKANGOPLAN = MDBExecuteRecordSet("SELECT * FROM f08 order by ID DESC", adOpenForwardOnly, adLockReadOnly)

    '訪問看護計画書情報数分処理を回す
    Do Until recHOMONKANGOPLAN.EOF
        '5.0のデータの有無をチェック
        Set recHOMONKANGOPLAN_New = FDBExecuteRecordSet("SELECT * FROM HOMONKANGO_PLAN WHERE " & _
        "PATIENT_ID=" & recHOMONKANGOPLAN("pat_id"), adOpenForwardOnly, adLockReadOnly)
        '"PATIENT_ID=" & recHOMONKANGOPLAN("pat_id") & " AND TARGET_DATE= " & "'" & Format(recHOMONKANGOPLAN("d01"), "yyyy/mm") & "/" & "01" & "'",
    
        If recHOMONKANGOPLAN_New.EOF Then
            '利用者IDのold番号を代入
            intPatientID_old = recHOMONKANGOPLAN("pat_id")
        
            '訪問看護計画書情報テーブルを移行
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
            '利用者IDのデータを移行
            strSQL = strSQL & recHOMONKANGOPLAN("pat_id") & ","
            '対象年月のデータを移行
            strSQL = strSQL & "'" & Format(recHOMONKANGOPLAN("d01"), "yyyy/mm") & "/" & "01" & "',"
            '要介護度のデータを移行
            'NULLの時は、「0」を移行
            If IsNull(recHOMONKANGOPLAN("o10")) Then
                strSQL = strSQL & "0,"
            Else
                '要介護度が「0」の時は、「1」自立を移行
                If recHOMONKANGOPLAN("o10") = 0 Then
                    strSQL = strSQL & "1,"
                '要介護度が「1」の時は、「11」要支援を移行
                ElseIf recHOMONKANGOPLAN("o10") = 1 Then
                    strSQL = strSQL & "11,"
                '要介護度が「2」の時は、「21」要介護1を移行
                ElseIf recHOMONKANGOPLAN("o10") = 2 Then
                    strSQL = strSQL & "21,"
                '要介護度が「3」の時は、「22」要介護2を移行
                ElseIf recHOMONKANGOPLAN("o10") = 3 Then
                    strSQL = strSQL & "22,"
                '要介護度が「4」の時は、「23」要介護3を移行
                ElseIf recHOMONKANGOPLAN("o10") = 4 Then
                    strSQL = strSQL & "23,"
                '要介護度が「5」の時は、「24」要介護4を移行
                ElseIf recHOMONKANGOPLAN("o10") = 5 Then
                    strSQL = strSQL & "24,"
                '要介護度が「6」の時は、「25」要介護5を移行
                ElseIf recHOMONKANGOPLAN("o10") = 6 Then
                    strSQL = strSQL & "25,"
                End If
            End If
            '医師氏名のデータを移行
            'NULLのとき
            If IsNull(recHOMONKANGOPLAN("t04")) Then
                strSQL = strSQL & "'',"
            Else
                '移行元のデータを移行（シングルクォートを置換）
                strSQL = strSQL & "'" & Replace(recHOMONKANGOPLAN("t04"), "'", "''") & "',"
            End If
            '作成年月日のデータを移行
            'NULLの時は、「NULL」文字を移行
            If IsNull(recHOMONKANGOPLAN("d01")) Then
                strSQL = strSQL & "NULL" & ","
            Else
                '作成年月日のデータを移行
                strSQL = strSQL & "'" & recHOMONKANGOPLAN("d01") & "',"
            End If
            '事業所氏名のデータを移行
            'NULLのとき
            If IsNull(recHOMONKANGOPLAN("t03")) Then
                strSQL = strSQL & "'',"
            Else
                '移行元データの移行（シングルクォートを置換）
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGOPLAN("t03"), 64), "'", "''") & "',"
            End If
            '管理者氏名のデータを移行
            'NULLのとき
            If IsNull(recHOMONKANGOPLAN("t02")) Then
                strSQL = strSQL & "'',"
            Else
                '移行元データの移行（シングルクォートを置換）
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGOPLAN("t02"), 22), "'", "''") & "',"
            End If
            '看護・リハビリテーションの目標のデータを移行
            'NULLのとき
            If IsNull(recHOMONKANGOPLAN("t05")) Then
                strSQL = strSQL & "'',"
            Else
                '移行元データの移行（シングルクォートを置換）
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGOPLAN("t05"), 572), "'", "''") & "',"
            End If
            '備考のデータを移行
            If IsNull(recHOMONKANGOPLAN("t06")) Then
                strSQL = strSQL & "'',"
            Else
                '移行元データの移行（シングルクォートを置換）
                strSQL = strSQL & "'" & Replace(Left(recHOMONKANGOPLAN("t06"), 172), "'", "''") & "',"
            End If
            '最終更新日にシステム日付を登録
            strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
            strSQL = strSQL & ")"
            Call FDBExecuteSQL(strSQL)
            
            '訪問看護計画書（問題・対応策）情報テーブルの取得
            Set recHOMONKANGOPLANNOTE = MDBExecuteRecordSet("SELECT * FROM f08sub WHERE " & _
            "F8_ID =" & recHOMONKANGOPLAN("ID") & "", adOpenForwardOnly, adLockReadOnly)
            
            '訪問看護計画書（問題・対応策）情報のデータ分ループを回す
            Do Until recHOMONKANGOPLANNOTE.EOF
                '作成年月日がNULLで無ければ、データ移行を行う
                If Not IsNull(recHOMONKANGOPLANNOTE("d00")) Then
                    '枝番の初期化<利用者IDとold番号が違うとき>
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
                    '利用者IDのデータを移行
                    strSQLNote = strSQLNote & recHOMONKANGOPLAN("pat_id") & ","
                    '枝番のデータを登録
                    strSQLNote = strSQLNote & intNoteID & ","
                    '問題点・解決策・日付のデータを移行
                    'NULLの時
                    If IsNull(recHOMONKANGOPLANNOTE("d00")) Then
                        '「NULL」文字を移行
                        strSQLNote = strSQLNote & "NULL" & ","
                    'NULLでない時
                    Else
                        '問題点・解決策・日付のデータを移行
                        strSQLNote = strSQLNote & "'" & recHOMONKANGOPLANNOTE("d00") & "',"
                    End If
                    '問題点・解決策・内容のデータを移行
                    'NULLの時
                    If IsNull(recHOMONKANGOPLANNOTE("t00")) Then
                        strSQLNote = strSQLNote & "'',"
                    Else
                        '移行元データの移行（シングルクォートを置換）
                        strSQLNote = strSQLNote & "'" & Replace(Left(recHOMONKANGOPLANNOTE("t00"), 3000), "'", "''") & "',"
                    End If
                    '最終更新日にシステム日付を登録
                    strSQLNote = strSQLNote & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
                    strSQLNote = strSQLNote & ")"
                    Call FDBExecuteSQL(strSQLNote)
                        
                    '枝番に1をたす
                    intNoteID = intNoteID + 1
                End If
                recHOMONKANGOPLANNOTE.MoveNext
            Loop
        End If
        recHOMONKANGOPLAN.MoveNext
    Loop
    
    Exit Sub
    
Err_Connection:

    MsgBox "データの移行に失敗しました。" & vbNewLine & "申し訳ありませんが、データの移行をはじめからやり直してください。" _
    , vbInformation + vbOKOnly, "データ移行失敗"
    
    End

End Sub

Public Sub ConvKYOTAKURYOYO()
'============================================================================================
'居宅療養管理指導書情報移行（全共通）
'============================================================================================
Dim recKYOTAKURYOYO As Object
Dim recKYOTAKURYOYO_New As Object
Dim strSQL As String
Dim varThisMonth As Variant
Dim varNextMonth As Variant

    'エラー処理
    On Error GoTo Err_Connection

    '居宅療養管理指導書情報テーブルの取得
    Set recKYOTAKURYOYO = MDBExecuteRecordSet("SELECT * FROM f04b order by ID DESC", adOpenForwardOnly, adLockReadOnly)

    '居宅療養管理指導書情報数分処理を回す
    Do Until recKYOTAKURYOYO.EOF
        '5.0のデータの有無をチェック
        Set recKYOTAKURYOYO_New = FDBExecuteRecordSet("SELECT * FROM KYOTAKU_RYOYO WHERE " & _
        "PATIENT_ID=" & recKYOTAKURYOYO("pat_id") & " AND TARGET_DATE= " & "'" & recKYOTAKURYOYO("d00") & "'", _
        adOpenForwardOnly, adLockReadOnly)
    
        If recKYOTAKURYOYO_New.EOF Then
            '居宅療養管理指導書情報テーブルを移行
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
            '利用者IDのデータを移行
            strSQL = strSQL & recKYOTAKURYOYO("pat_id") & ","
            '対象年月のデータを移行
            strSQL = strSQL & "'" & recKYOTAKURYOYO("d00") & "',"
            '要介護度のデータを移行
            '「NULL」の時、「NULL」文字を移行
            If IsNull(recKYOTAKURYOYO("o010")) Then
                strSQL = strSQL & "0,"
            Else
                '要介護度のデータが「1」の時、「11」要支援を移行
                If recKYOTAKURYOYO("o010") = 1 Then
                    strSQL = strSQL & "11,"
                '要介護度のデータが「2」の時、「21」要介護1を移行
                ElseIf recKYOTAKURYOYO("o010") = 2 Then
                    strSQL = strSQL & "21,"
                '要介護度のデータが「3」の時、「22」要介護2を移行
                ElseIf recKYOTAKURYOYO("o010") = 3 Then
                    strSQL = strSQL & "22,"
                '要介護度のデータが「4」の時、「23」要介護3を移行
                ElseIf recKYOTAKURYOYO("o010") = 4 Then
                    strSQL = strSQL & "23,"
                '要介護度のデータが「5」の時、「24」要介護4を移行
                ElseIf recKYOTAKURYOYO("o010") = 5 Then
                    strSQL = strSQL & "24,"
                '要介護度のデータが「6」の時、「25」要介護5を移行
                ElseIf recKYOTAKURYOYO("o010") = 6 Then
                    strSQL = strSQL & "25,"
                Else
                    strSQL = strSQL & "0,"
                End If
            End If
            '主病名のデータを移行
            'strSQL = strSQL & "'" & recKYOTAKURYOYO("t09") & "',"
            '発祥年月日のデータを移行
            'NULLの時、「NULL」文字を移行
            'If IsNull(recKYOTAKURYOYO("d03")) Then
            '    strSQL = strSQL & "NULL" & ","
            'Else
                '発祥年月日のデータを移行
            '    strSQL = strSQL & "'" & recKYOTAKURYOYO("d03") & "',"
            'End If
            '障害高齢者日常生活自立度のデータ移行
            'NULLの時、「NULL」文字を移行
            If IsNull(recKYOTAKURYOYO("o020")) Then
                strSQL = strSQL & "NULL" & ","
            Else
                '障害高齢者日常生活自立度のデータを移行
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
            '認知症高齢者日常生活自立度のデータを移行
            'NULLの時、「NULL」文字を移行
            If IsNull(recKYOTAKURYOYO("o030")) Then
                strSQL = strSQL & "NULL" & ","
            Else
                '認知症高齢者日常生活自立度のデータを移行
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
            '在宅療養生活のポイントの作成年月日のデータを移行
            strSQL = strSQL & "'" & recKYOTAKURYOYO("d00") & "',"
            '今月の訪問日のデータの有無をチェック
            If InStr(recKYOTAKURYOYO("t19"), ",") <> 0 Then
                '取得したデータをカンマで分割する
                varThisMonth = Split(recKYOTAKURYOYO("t19"), ",")
                'カンマで分割したデータが0以上の時、処理を行う
                If UBound(varThisMonth) >= 0 Then
                    'NULLの時、「NULL」文字を移行
                    If IsNull(varThisMonth(0)) Then
                        strSQL = strSQL & "NULL" & ","
                    Else
                        '作成年月日から年月を取得し、取得したデータを日とし、日付型でフォーマットし
                        'さらに、フォーマットしたデータの日付に矛盾が無いかをチェックする
                        If IsDate(Format(Format(recKYOTAKURYOYO("d00"), "yyyy/mm") & "/" & varThisMonth(0), "yyyy/mm/dd")) Then
                            '矛盾が無ければ、フォーマットした日付を移行する
                            strSQL = strSQL & "'" & Format(Format(recKYOTAKURYOYO("d00"), "yyyy/mm") & "/" & varThisMonth(0), "yyyy/mm/dd") & "',"
                        Else
                            '矛盾があれば、「NULL」文字を移行する
                            strSQL = strSQL & "NULL" & ","
                        End If
                    End If
                Else
                    'カンマで分割したデータが0以下の時は、「NULL」文字を移行する
                    strSQL = strSQL & "NULL" & ","
                End If
                '以降上記と同じ処理を5回続ける
                'カンマで分割したデータが1以上の時、処理を行う
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
                'カンマで分割したデータが2以上の時、処理を行う
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
                'カンマで分割したデータが3以上の時、処理を行う
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
                'カンマで分割したデータが4以上の時、処理を行う
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
                'カンマで分割したデータが5以上の時、処理を行う
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
                '今月の訪問日のデータがNULLの時は、6回「NULL」文字を移行する
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
            End If
            '来月の訪問日のデータの有無をチェック
            If InStr(recKYOTAKURYOYO("t01"), ",") <> 0 Then
                '取得したデータをカンマで分割する
                varNextMonth = Split(recKYOTAKURYOYO("t01"), ",")
                'カンマで分割したデータが0以上の時、処理を行う
                If UBound(varNextMonth) >= 0 Then
                    'NULLの時、「NULL」文字を移行
                    If IsNull(varNextMonth(0)) Then
                        strSQL = strSQL & "NULL" & ","
                    Else
                        '作成年月日から年月を取得しDateAddにより次月の年月に変換し、取得したデータを日とし、日付型でフォーマットし
                        'さらに、フォーマットしたデータの日付に矛盾が無いかをチェックする
                        If IsDate(Format(Format(DateAdd("m", 1, recKYOTAKURYOYO("d00")), "yyyy/mm") & "/" & varNextMonth(0), "yyyy/mm/dd")) Then
                            '矛盾が無ければ、フォーマットした日付を移行する
                            strSQL = strSQL & "'" & Format(Format(DateAdd("m", 1, recKYOTAKURYOYO("d00")), "yyyy/mm") & "/" & varNextMonth(0), "yyyy/mm/dd") & "',"
                        Else
                             '矛盾があれば、「NULL」文字を移行する
                            strSQL = strSQL & "NULL" & ","
                        End If
                    End If
                Else
                    'カンマで分割したデータが0以下の時は、「NULL」文字を移行する
                    strSQL = strSQL & "NULL" & ","
                End If
                '以降上記と同じ処理を5回続ける
                'カンマで分割したデータが1以上の時、処理を行う
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
                'カンマで分割したデータが2以上の時、処理を行う
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
                'カンマで分割したデータが3以上の時、処理を行う
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
                'カンマで分割したデータが4以上の時、処理を行う
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
                'カンマで分割したデータが5以上の時、処理を行う
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
                '来月の訪問日のデータがNULLの時は、6回「NULL」文字を移行する
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
                strSQL = strSQL & "NULL" & ","
            End If
            '（）月のアドバイスのデータの移行
            'NULLの時は、「0」を移行
            If IsNull(recKYOTAKURYOYO("n01")) Then
                strSQL = strSQL & "0,"
            Else
                '（）月のアドバイスのデータを移行
                strSQL = strSQL & recKYOTAKURYOYO("n01") & ","
            End If
            'アドバイスのデータの移行
            If IsNull(recKYOTAKURYOYO("t02")) Then
                strSQL = strSQL & "'',"
            Else
                '移行元のデータを移行（シングルクォートを置換）
                strSQL = strSQL & "'" & Replace(Left(recKYOTAKURYOYO("t02"), 1000), "'", "''") & "',"
            End If
            '医療機関名のデータの移行
            'NULLのとき
            If IsNull(recKYOTAKURYOYO("t03")) Then
                strSQL = strSQL & "'',"
            Else
                '移行元のデータを移行（シングルクォートを置換）
                strSQL = strSQL & "'" & Replace(Left(recKYOTAKURYOYO("t03"), 64), "'", "''") & "',"
            End If
            '担当医師名のデータの移行
            'NULLのとき
            If IsNull(recKYOTAKURYOYO("t04")) Then
                strSQL = strSQL & "'',"
            Else
                '移行元のデータを移行（シングルクォートを置換）
                strSQL = strSQL & "'" & Replace(Left(recKYOTAKURYOYO("t04"), 32), "'", "''") & "',"
            End If
            '連絡先のデータの移行
            'strSQL = strSQL & "'" & recKYOTAKURYOYO("t05") & "',"
            '介護支援専門員のデータの移行
            'NULLのとき
            If IsNull(recKYOTAKURYOYO("t06")) Then
                strSQL = strSQL & "'',"
            Else
                strSQL = strSQL & "'" & Replace(recKYOTAKURYOYO("t06"), "'", "''") & "',"
            End If
            '事業所名のデータの移行
            'NULLのとき
            If IsNull(recKYOTAKURYOYO("t07")) Then
                strSQL = strSQL & "'',"
            Else
                strSQL = strSQL & "'" & Replace(Left(recKYOTAKURYOYO("t07"), 64), "'", "''") & "',"
            End If
            '居宅療養管理指導書のデータの移行
            'NULLの時、「NULL」文字を移行
            If IsNull(recKYOTAKURYOYO("d01")) Then
                strSQL = strSQL & "NULL" & ","
            Else
                '居宅療養管理指導書のデータの移行
                strSQL = strSQL & "'" & recKYOTAKURYOYO("d01") & "',"
            End If
'            '病状の変化／項目のデータの移行
'            'NULLの時、「0」を移行
'            If IsNull(recKYOTAKURYOYO("o040")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '病状の変化／項目のデータの移行
'                strSQL = strSQL & recKYOTAKURYOYO("o040") & ","
'            End If
'            '病状の変化／詳細のデータを移行
'            'NULLの時、「0」を移行
'            If IsNull(recKYOTAKURYOYO("o050")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '病状の変化／詳細のデータを移行
'                strSQL = strSQL & recKYOTAKURYOYO("o050") & ","
'            End If
'            '病状の変化／その他留意事項のデータを移行
'            strSQL = strSQL & "'" & Left(recKYOTAKURYOYO("t10"), 100) & "',"
'            '精神の状態／項目のデータを移行
'            'NULLの時、「0」を移行
'            If IsNull(recKYOTAKURYOYO("o090")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '精神の状態／項目のデータを移行
'                strSQL = strSQL & recKYOTAKURYOYO("o090") & ","
'            End If
'            '精神の状態／詳細（→）のデータの移行
'            strSQL = strSQL & "'" & recKYOTAKURYOYO("t13") & "',"
'            '精神の状態／その他留意事項のデータの移行
'            strSQL = strSQL & "'" & Left(recKYOTAKURYOYO("t14"), 100) & "',"
'            '移動／項目のデータ移行
'            'NULLの時、「0」を移行
'            If IsNull(recKYOTAKURYOYO("o060")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '移動／項目のデータ移行
'                strSQL = strSQL & recKYOTAKURYOYO("o060") & ","
'            End If
'            '移動／その他留意事項のデータの移行
'            strSQL = strSQL & "'" & Left(recKYOTAKURYOYO("t11"), 100) & "',"
'            '摂食／項目のデータ移行
'            'NULLの時、「0」を移行
'            If IsNull(recKYOTAKURYOYO("o100")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '摂食／項目のデータ移行
'                strSQL = strSQL & recKYOTAKURYOYO("o100") & ","
'            End If
'            '摂食／詳細のデータの移行
'            'NULLの時、「0」を移行
'            If IsNull(recKYOTAKURYOYO("o110")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '摂食／詳細のデータの移行
'                strSQL = strSQL & recKYOTAKURYOYO("o110") & ","
'            End If
'            '摂食／その他の留意事項のデータの移行
'            strSQL = strSQL & "'" & Left(recKYOTAKURYOYO("t15"), 100) & "',"
'            '入浴／項目のデータの移行
'            'NULLの時、「0」を移行
'            If IsNull(recKYOTAKURYOYO("o070")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '入浴／項目のデータの移行
'                strSQL = strSQL & recKYOTAKURYOYO("o070") & ","
'            End If
'            '入浴／詳細のデータの移行
'            'NULLの時、「0」を移行
'            If IsNull(recKYOTAKURYOYO("o080")) Then
'                strSQL = strSQL & "0,"
'            Else
'                '入浴／詳細のデータの移行
'                strSQL = strSQL & recKYOTAKURYOYO("o080") & ","
'            End If
'            '入浴／その他留意事項のデータの移行
'            strSQL = strSQL & "'" & Left(recKYOTAKURYOYO("t12"), 100) & "',"
'            'その他注意点／血圧・糖尿病・発熱のデータの移行
'            'NULLの時、「0」を移行
'            If IsNull(recKYOTAKURYOYO("c10")) Then
'                strSQL = strSQL & "0,"
'                strSQL = strSQL & "0,"
'                strSQL = strSQL & "0,"
'            Else
'                'その他注意点／血圧・糖尿病・発熱のデータの移行
'                strSQL = strSQL & Left(recKYOTAKURYOYO("c10"), 1) & ","
'                strSQL = strSQL & Mid(recKYOTAKURYOYO("c10"), 2, 1) & ","
'                strSQL = strSQL & Right(recKYOTAKURYOYO("c10"), 1) & ","
'            End If
'            'その他注意点／詳細（血圧H）のデータを移行
'            'NULLの時、「0」を移行
'            If IsNull(recKYOTAKURYOYO("n02")) Then
'                strSQL = strSQL & "0,"
'            Else
'                'その他注意点／詳細（血圧H）のデータを移行
'                strSQL = strSQL & recKYOTAKURYOYO("n02") & ","
'            End If
'            'その他注意点／詳細（血圧L）のデータを移行
'            'NULLの時、「0」を移行
'            If IsNull(recKYOTAKURYOYO("n03")) Then
'                strSQL = strSQL & "0,"
'            Else
'                'その他注意点／詳細（血圧L）のデータを移行
'                strSQL = strSQL & recKYOTAKURYOYO("n03") & ","
'            End If
'            'その他注意点／詳細（体温）のデータを移行
'            strSQL = strSQL & "'" & recKYOTAKURYOYO("n04") & "',"
'            'その他注意点／その他留意点のデータを移行
'            strSQL = strSQL & "'" & Left(recKYOTAKURYOYO("t16"), 100) & "',"
'            '定時処方内容のデータの移行
'            strSQL = strSQL & "'" & Left(recKYOTAKURYOYO("t17"), 255) & "',"
'            '利用者への指示内容のデータの移行
'            strSQL = strSQL & "'" & Left(recKYOTAKURYOYO("t18"), 255) & "',"
            '最終更新日にシステム日付を登録
            strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
            strSQL = strSQL & ")"
            Call FDBExecuteSQL(strSQL)
        End If
        recKYOTAKURYOYO.MoveNext
    Loop
    
    Exit Sub

Err_Connection:

    MsgBox "データの移行に失敗しました。" & vbNewLine & "申し訳ありませんが、データの移行をはじめからやり直してください。" _
    , vbInformation + vbOKOnly, "データ移行失敗"
    
    End

End Sub

Public Sub ConvINSURER()
'============================================================================================
'保険者情報移行（全共通）
'============================================================================================
Dim recINSURER As Object
Dim strSQL As String
Dim varTel As Variant

    'エラー処理
    On Error GoTo Err_Connection

    '保険者情報テーブルの取得
    Set recINSURER = MDBExecuteRecordSet("SELECT * FROM m_insr", adOpenForwardOnly, adLockReadOnly)
    
    '保険者情報数分処理を回す
    Do Until recINSURER.EOF
        
        '電話番号をハイフンで分割
        If InStr(recINSURER("insr_tel"), "-") <> 0 Then
            '取得したデータを半角に変更
            varTel = Split(StrConv(recINSURER("insr_tel"), vbNarrow), "-")
        Else
            varTel = recINSURER("insr_tel")
        End If
        
        '保険者情報テーブルを移行
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
        '保険者番号のデータを移行
        strSQL = strSQL & "'" & recINSURER("insr_no") & "',"
        '保険者名のデータを移行
        'NULLの時は、空文字を移行
        If IsNull(recINSURER("insr_nm")) Then
            strSQL = strSQL & "'',"
        'シングルクォートを置換して移行する。
        Else
            strSQL = strSQL & "'" & Replace(recINSURER("insr_nm"), "'", "''") & "',"
        End If
        '郵便番号のデータを移行
        'NULLの時は、空文字を移行
        If IsNull(recINSURER("insr_zip_code")) Then
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        '郵便番号のデータの長さが3以上の時
        ElseIf Len(recINSURER("insr_zip_code")) > 3 Then
            '郵便番号のデータの左から3桁を移行
            strSQL = strSQL & "'" & Left$(recINSURER("insr_zip_code"), 3) & "',"
            '郵便番号のデータの4桁目からデータを移行
            strSQL = strSQL & "'" & Mid$(recINSURER("insr_zip_code"), 4, Len(recINSURER("insr_zip_code"))) & "',"
        '上記以外の時は
        Else
            '郵便番号のデータを左からデータの数分移行
            strSQL = strSQL & "'" & Left$(recINSURER("insr_zip_code"), Len(recINSURER("insr_zip_code"))) & "',"
            '空データを移行
            strSQL = strSQL & "'',"
        End If
        '住所のデータを移行
        strSQL = strSQL & "'" & recINSURER("insr_address") & "',"
        '電話番号のデータを移行
        'NULLの時、空データを3個移行
        If IsNull(recINSURER("insr_tel")) Then
                strSQL = strSQL & "'',"
                strSQL = strSQL & "'',"
                strSQL = strSQL & "'',"
        Else
            'ハイフンの区切りがある時のデータ移行
            If InStr(recINSURER("insr_tel"), "-") <> 0 Then
                '分割したデータが数値型かチェックする
                If IsNumeric(varTel(0)) = True Then
                    '左から6桁のデータを移行
                    strSQL = strSQL & "'" & Left$(varTel(0), 6) & "',"
                '数値型でない時
                Else
                    '空データを移行
                    strSQL = strSQL & "'',"
                End If
                '分割したデータの個数が0以上の時
                If UBound(varTel) > 0 Then
                    '分割したデータが数値型かチェックする
                    If IsNumeric(varTel(1)) = True Then
                        'NULLでない時、左から4桁のデータを移行
                        If Not IsNull(varTel(1)) Then strSQL = strSQL & "'" & Left$(varTel(1), 4) & "',"
                    '数値型でないとき
                    Else
                        '空データを移行
                        strSQL = strSQL & "'',"
                    End If
                '分割したデータの個数が0以下
                Else
                    '空データを移行
                    strSQL = strSQL & "'',"
                End If
                '分割したデータの個数が1以上の時
                If UBound(varTel) > 1 Then
                    '数値型のチェック
                    If IsNumeric(varTel(2)) = True Then
                        'NULLの時、左から4桁のデータを移行
                        If Not IsNull(varTel(2)) Then strSQL = strSQL & "'" & Left$(varTel(2), 4) & "',"
                    '数値型でない時
                    Else
                        '空データを移行
                        strSQL = strSQL & "'',"
                    End If
                '分割したデータが1以下
                Else
                    '空データを移行
                    strSQL = strSQL & "'',"
                End If
            'ハイフンの区切りの無いとき
            Else
                '数値型のチェック
                If IsNumeric(varTel) = True Then
                    '左から6桁のデータを移行
                    strSQL = strSQL & "'" & Left$(varTel, 6) & "',"
                '数値型でないとき
                Else
                    '空のデータを移行
                    strSQL = strSQL & "'',"
                End If
                '空のデータを2個移行
                strSQL = strSQL & "'',"
                strSQL = strSQL & "'',"
            End If
        End If
        '削除フラグに「0」を登録
        strSQL = strSQL & "0,"
        '最終更新日にシステム日付を登録
        strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
        strSQL = strSQL & ")"
        
        Call FDBExecuteSQL(strSQL)
    
        recINSURER.MoveNext
    Loop
    
    Exit Sub
    
Err_Connection:

    MsgBox "データの移行に失敗しました。" & vbNewLine & "申し訳ありませんが、データの移行をはじめからやり直してください。" _
    , vbInformation + vbOKOnly, "データ移行失敗"
    
    End
    
End Sub

Public Sub ConvProviderInfo()
'==============================================================================================
'短期入所・施設関連情報
'==============================================================================================
Dim recProviderInfo As Object
Dim strSQL As String

    'エラー処理
    On Error GoTo Err_Connection

    '利用者情報テーブルの取得
    Set recProviderInfo = MDBExecuteRecordSet("SELECT * FROM m_insd", adOpenForwardOnly, adLockReadOnly)
    
    '利用者情報数分処理を回す
    Do Until recProviderInfo.EOF
    
        '短期・施設関連情報を移行
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
        '利用者IDのデータ移行
        strSQL = strSQL & recProviderInfo("pat_id") & ","
        '施設履歴番号に「1」を移行
        strSQL = strSQL & 1 & ","
        '特定入所者フラグのデータを移行
        'NULLの時
        If IsNull(recProviderInfo("sp59_flg")) Then
            '「0」を移行
            strSQL = strSQL & 0 & ","
        'NULL以外のとき
        Else
            If recProviderInfo("sp59_flg") = True Then
                '「2」を移行
                strSQL = strSQL & 2 & ","
            Else
                '「1」を移行
                strSQL = strSQL & 1 & ","
            End If
        End If
        '食費負担限度額のデータを移行
        'NULLの時
        If IsNull(recProviderInfo("sp59_shokuhi")) Then
            '「0」を移行
            strSQL = strSQL & 0 & ","
        'NULL以外のとき
        Else
            '移行元からデータを移行
            strSQL = strSQL & recProviderInfo("sp59_shokuhi") & ","
        End If
        'ユニット型個室負担限度額
        'NULLの時
        If IsNull(recProviderInfo("sp59_unit_koshitsu")) Then
            '「0」を移行
            strSQL = strSQL & 0 & ","
        'NULL以外のとき
        Else
            '移行元からデータを移行
            strSQL = strSQL & recProviderInfo("sp59_unit_koshitsu") & ","
        End If
        'ユニット型準個室負担限度額
        'NULLの時
        If IsNull(recProviderInfo("sp59_unit_junkoshitsu")) Then
            '「0」を移行
            strSQL = strSQL & 0 & ","
        'NULL以外のとき
        Else
            '移行元からデータを移行
            strSQL = strSQL & recProviderInfo("sp59_unit_junkoshitsu") & ","
        End If
        '従来型個室(特養)負担限度額
        'NULLの時
        If IsNull(recProviderInfo("sp59_juurai_koshitsu_tokuyou")) Then
            '「0」を移行
            strSQL = strSQL & 0 & ","
        'NULL以外のとき
        Else
            '移行元からデータを移行
            strSQL = strSQL & recProviderInfo("sp59_juurai_koshitsu_tokuyou") & ","
        End If
        '従来型個室(老健･療養)負担限度額
        'NULLの時
        If IsNull(recProviderInfo("sp59_juurai_koshitsu_rouken_ryouyou")) Then
            '「0」を移行
            strSQL = strSQL & 0 & ","
        'NULL以外のとき
        Else
            '移行元からデータを移行
            strSQL = strSQL & recProviderInfo("sp59_juurai_koshitsu_rouken_ryouyou") & ","
        End If
        '多床室負担限度額
        'NULLの時
        If IsNull(recProviderInfo("sp59_tashoushitsu")) Then
            '「0」を移行
            strSQL = strSQL & 0 & ","
        'NULL以外の時
        Else
            '移行元からデータを移行
            strSQL = strSQL & recProviderInfo("sp59_tashoushitsu") & ","
        End If
        '旧措置入所者特例フラグ
        'NULLの時
        If IsNull(recProviderInfo("kyuu_sochi_nyuusho")) Then
            '「0」を移行
            strSQL = strSQL & 0 & ","
        'NULL以外のとき
        Else
            '移行元からデータを移行
            strSQL = strSQL & recProviderInfo("kyuu_sochi_nyuusho") & ","
        End If
        '主傷病名
        If IsNull(recProviderInfo("main_disease")) Then
            '空のデータを移行
            strSQL = strSQL & "'',"
        'NULL以外のとき
        Else
            '移行元からデータを移行（シングルクォートを置換）
            strSQL = strSQL & "'" & Replace(recProviderInfo("main_disease"), "'", "''") & "',"
        End If
        '最終更新日にシステム日付を登録
        strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
        strSQL = strSQL & ")"
        
        Call FDBExecuteSQL(strSQL)
    
        recProviderInfo.MoveNext
    Loop
    
    Exit Sub
    
Err_Connection:

    MsgBox "データの移行に失敗しました。" & vbNewLine & "申し訳ありませんが、データの移行をはじめからやり直してください。" _
    , vbInformation + vbOKOnly, "データ移行失敗"
    
    End

End Sub

Public Sub ConvPATIENT()
'============================================================================================
'利用者情報移行（全共通）
'============================================================================================
Dim recPATIENT As Object
Dim strSQL As String
Dim varName As Variant
Dim varKanaName As Variant
Dim varTel As Variant

    'エラー処理
    On Error GoTo Err_Connection

    '利用者情報テーブルの取得
    Set recPATIENT = MDBExecuteRecordSet("SELECT * FROM m_insd", adOpenForwardOnly, adLockReadOnly)
        
    '利用者情報数分処理を回す
    Do Until recPATIENT.EOF
        
        '氏名をスペースで分割
        If InStr(recPATIENT("pat_nm"), " ") <> 0 Then
            varName = Split(recPATIENT("pat_nm"), " ")
        ElseIf InStr(recPATIENT("pat_nm"), "　") <> 0 Then
            varName = Split(recPATIENT("pat_nm"), "　")
        Else
            varName = recPATIENT("pat_nm")
        End If
        'かな氏名をスペースで分割
        If InStr(recPATIENT("pat_knm"), " ") <> 0 Then
            varKanaName = Split(recPATIENT("pat_knm"), " ")
        ElseIf InStr(recPATIENT("pat_knm"), "　") <> 0 Then
            varKanaName = Split(recPATIENT("pat_knm"), "　")
        Else
            varKanaName = recPATIENT("pat_knm")
        End If
        '電話番号をハイフンで分割
        If InStr(recPATIENT("pat_tel"), "-") <> 0 Then
            varTel = Split(StrConv(recPATIENT("pat_tel"), vbNarrow), "-")
        Else
            varTel = recPATIENT("pat_tel")
        End If
        
        '利用者情報テーブルを移行
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
        '利用者IDのデータ移行
        strSQL = strSQL & recPATIENT("pat_id") & ","
        '利用者内部IDを移行
        'NULLの時
        If IsNull(recPATIENT("pat_cd")) Then
            '空のデータを移行
            strSQL = strSQL & "'',"
        Else
            '移行元データを移行（シングルクォートを置換）
            strSQL = strSQL & "'" & Replace(recPATIENT("pat_cd"), "'", "''") & "',"
        End If
        '利用者氏名のデータを移行
        'スペースで分割したデータが、0個で無ければ
        If InStr(recPATIENT("pat_nm"), " ") <> 0 Or InStr(recPATIENT("pat_nm"), "　") <> 0 Then
            '利用者氏名のデータを移行
            'NULLの時
            If IsNull(varName(0)) Then
                '空のデータを移行
                strSQL = strSQL & "'',"
            Else
                '元のデータを移行（シングルクォート）
                strSQL = strSQL & "'" & Replace(Left(varName(0), 16), "'", "''") & "',"
            End If
            'NULLの時
            If IsNull(varName(1)) Then
                '空のデータを移行
                strSQL = strSQL & "'',"
            Else
                '元のデータを移行（シングルクォート）
                strSQL = strSQL & "'" & Replace(Left(varName(1), 16), "'", "''") & "',"
            End If
        '分割データが0個なら
        Else
            '利用者氏名のデータを移行
            'NULLの時
            If IsNull(varName) Then
                '空のデータを移行
                strSQL = strSQL & "'',"
            Else
                strSQL = strSQL & "'" & Replace(Left(varName, 16), "'", "''") & "',"
            End If
            '空のデータを移行
            strSQL = strSQL & "'',"
        End If
        '利用者かな氏名のデータを移行
        'スペースで分割したデータが、0個で無ければ
        If InStr(recPATIENT("pat_knm"), " ") <> 0 Or InStr(recPATIENT("pat_knm"), "　") <> 0 Then
            '利用者かな氏名を全角ひらがなに変換し、データを移行
            'NULLの時
            If IsNull(varKanaName(0)) Then
                '空のデータを移行
                strSQL = strSQL & "'',"
            Else
                '移行元のデータを移行（シングルクォートを置換）
                strSQL = strSQL & "'" & Replace(Left(StrConv(StrConv(varKanaName(0), vbWide), vbHiragana), 16), "'", "''") & "',"
            End If
            'NULLの時
            If IsNull(varKanaName(1)) Then
                '空のデータを移行
                strSQL = strSQL & "'',"
            Else
                '移行元のデータを移行（シングルクォートを置換）
                strSQL = strSQL & "'" & Replace(Left(StrConv(StrConv(varKanaName(1), vbWide), vbHiragana), 16), "'", "''") & "',"
            End If
        Else
            '利用者かな氏名を全角ひらがなに変換し、データを移行
            'NULLの時
            If IsNull(varKanaName) Then
                '空のデータを移行
                strSQL = strSQL & "'',"
            Else
            
                strSQL = strSQL & "'" & Replace(Left(StrConv(StrConv(varKanaName, vbWide), vbHiragana), 16), "'", "''") & "',"
            End If
            '空のデータを移行
            strSQL = strSQL & "'',"
        End If
        '性別のデータを移行
        'NULLで無い時
        If Not IsNull(recPATIENT("pat_sex")) Then
            '性別のデータを移行
            strSQL = strSQL & recPATIENT("pat_sex") & ","
        'NULLの時
        Else
            '「0」を移行
            strSQL = strSQL & "0,"
        End If
        '生年月日のデータを移行
        'NULLの時
        If IsNull(recPATIENT("pat_birthday")) Then
            '「NULL」文字を移行
            strSQL = strSQL & "NULL" & ","
        'NULL以外
        Else
            '認定日のデータを移行
            strSQL = strSQL & "'" & recPATIENT("pat_birthday") & "',"
        End If
        '電話番号のデータを移行
        'NULLの時
        If IsNull(recPATIENT("pat_tel")) Then
            '空データを3個移行
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        'NULLでなく、ハイフンで分割したデータが0個以上の時
        ElseIf InStr(recPATIENT("pat_tel"), "-") <> 0 Then
            '数値型の時
            If IsNumeric(varTel(0)) = True Then
                '左から6桁のデータを移行
                strSQL = strSQL & "'" & Left$(varTel(0), 6) & "',"
            '数値型でない時
            Else
                '空のデータを移行
                strSQL = strSQL & "'',"
            End If
            '分割したデータが0個以上の時
            If UBound(varTel) > 0 Then
                '数値型の時
                If IsNumeric(varTel(1)) = True Then
                    'NULLで無い時、左から4桁をデータ移行
                    If Not IsNull(varTel(1)) Then strSQL = strSQL & "'" & Left$(varTel(1), 4) & "',"
                '数値型でないとき
                Else
                    '空のデータを移行
                    strSQL = strSQL & "'',"
                End If
            '分割したデータが0個の時
            Else
                '空データを移行
                strSQL = strSQL & "'',"
            End If
            '分割したデータが1個以上の時
            If UBound(varTel) > 1 Then
                '数値型でないとき
                If IsNumeric(varTel(2)) = True Then
                    'NULLでない時、左から4桁をデータ移行
                    If Not IsNull(varTel(2)) Then strSQL = strSQL & "'" & Left$(varTel(2), 4) & "',"
                '数値型でないとき
                Else
                    '空データでないとき
                    strSQL = strSQL & "'',"
                End If
            '分割したデータが0個のとき
            Else
                '空データを移行
                strSQL = strSQL & "'',"
            End If
        'NULLでなく、ハイフンで分割したデータが0個の時
        Else
            '数値型のとき
            If IsNumeric(varTel) = True Then
                '左から6桁のデータを移行
                strSQL = strSQL & "'" & Left$(varTel, 6) & "',"
            '数値型でない時
            Else
                '空のデータを移行
                strSQL = strSQL & "'',"
            End If
            '空のデータを2個移行
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        End If
        '郵便番号のデータを移行
        'NULLの時
        If IsNull(recPATIENT("pat_zip_code")) Then
            '空のデータを2個移行
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        '郵便番号のデータの長さが3以上の時
        ElseIf Len(recPATIENT("pat_zip_code")) > 3 Then
            '左から3桁のデータを移行
            strSQL = strSQL & "'" & Left$(recPATIENT("pat_zip_code"), 3) & "',"
            '4桁からデータの最終までのデータを移行
            strSQL = strSQL & "'" & Mid$(recPATIENT("pat_zip_code"), 4, Len(recPATIENT("pat_zip_code"))) & "',"
        'データの長さが3以下の時
        Else
            '左から3桁のデータを移行
            strSQL = strSQL & "'" & Left$(recPATIENT("pat_zip_code"), 3) & "',"
            '空のデータを移行
            strSQL = strSQL & "'',"
        End If
        '住所のデータを移行
        If IsNull(recPATIENT("pat_address")) Then
            '空のデータを移行
            strSQL = strSQL & "'',"
        Else
            '移行元のデータを移行（シングルクォートを置換）
            strSQL = strSQL & "'" & Replace(recPATIENT("pat_address"), "'", "''") & "',"
        End If
        '表示フラグのデータを移行
        'NULLの時
        If IsNull(recPATIENT("hidden_pat")) Then
            '「0」を移行
            strSQL = strSQL & "0,"
        'NULLでない時
        Else
            '表示フラグのデータを移行
            strSQL = strSQL & recPATIENT("hidden_pat") & ","
        End If
        '削除フラグに「0」を登録
        strSQL = strSQL & "0,"
        '最終更新日にシステム日付を登録
        strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
        strSQL = strSQL & ")"
        
        Call FDBExecuteSQL(strSQL)
    
        '============================================================================================
        '認定履歴情報移行（全共通）
        '============================================================================================
        Dim recNINTEIRIREKI As Object
        Dim recNINTEIRIREKI_COUNT As Object
        Dim strNinteiSQL As String


            '認定履歴情報テーブルから履歴を取得
            Set recNINTEIRIREKI_COUNT = MDBExecuteRecordSet("SELECT * FROM m_nurs_stat_hist WHERE " & _
            "pat_id=" & recPATIENT("pat_id") & " ORDER BY id DESC", adOpenForwardOnly, adLockReadOnly)
            
            '認定履歴情報テーブルから有効期間最大のデータを取得
            Set recNINTEIRIREKI = MDBExecuteRecordSet("SELECT * FROM m_nurs_stat_hist WHERE pat_id = " & recPATIENT("pat_id") & " AND " & _
            "valid_from=(select MAX(valid_from) from m_nurs_stat_hist WHERE pat_id=" & recPATIENT("pat_id") & ")", _
            adOpenForwardOnly, adLockReadOnly)


            '認定履歴情報の有効期間が空で無い時
            If Not recNINTEIRIREKI.EOF Then
                                    
                '認定履歴情報テーブルを移行
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
                '利用者番号のデータを移行
                strNinteiSQL = strNinteiSQL & recPATIENT("pat_id") & ","
                '認定履歴番号に「1」を登録
                strNinteiSQL = strNinteiSQL & "'" & 1 & "',"
                '保険者番号のデータを移行
                'NULLの時
                If IsNull(recPATIENT("insr_no")) Then
                    '空のデータを移行
                    strNinteiSQL = strNinteiSQL & "'',"
                Else
                    '移行元データの移行（シングルクォートを置換）
                    strNinteiSQL = strNinteiSQL & "'" & Replace(recPATIENT("insr_no"), "'", "''") & "',"
                End If
                '被保険者番号のデータ移行
                If IsNull(recPATIENT("insd_no")) Then
                    '空のデータを移行
                    strNinteiSQL = strNinteiSQL & "'',"
                Else
                    '移行元データの移行（シングルクォートを置換）
                    strNinteiSQL = strNinteiSQL & "'" & Replace(recPATIENT("insd_no"), "'", "''") & "',"
                End If
                '給付率のデータを移行
                strNinteiSQL = strNinteiSQL & recPATIENT("ins_rate") & ","
                '居宅計画作成者のデータを移行
                'NULLの時
                If IsNull(recPATIENT("planner")) Then
                    '「0」を移行
                    strNinteiSQL = strNinteiSQL & "0,"
                'NULLでない時
                Else
                    '居宅計画作成者のデータを移行
                    strNinteiSQL = strNinteiSQL & recPATIENT("planner") & ","
                End If
                '居宅サービス作成事業所番号のデータを移行
                strNinteiSQL = strNinteiSQL & "'" & recPATIENT("planner_no") & "',"
                '申請種別コードのデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI("apply_type")) Then
                    '「0」を移行
                    strNinteiSQL = strNinteiSQL & "0,"
                'NULLでない時
                Else
                    '申請種別コードのデータを移行
                    strNinteiSQL = strNinteiSQL & recNINTEIRIREKI("apply_type") & ","
                End If
                '申請中コードのデータ移行
                'NULLの時
                If IsNull(recNINTEIRIREKI("change_apply")) Then
                    '「0」を移行
                    strNinteiSQL = strNinteiSQL & "0,"
                'NULLでない時
                Else
                    '移行元データが「2」時
                    If recNINTEIRIREKI("change_apply") = 2 Then
                        '「1」を移行
                        strNinteiSQL = strNinteiSQL & "1,"
                    '「2」以外のとき
                    Else
                        '「0」を移行
                        strNinteiSQL = strNinteiSQL & "0,"
                    End If
                End If
                '要介護状態区分コードのデータを移行
                strNinteiSQL = strNinteiSQL & recNINTEIRIREKI("nurs_stat") & ","
                '申請日のデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI("apply_date")) Then
                    '「NULL」文字を登録
                    strNinteiSQL = strNinteiSQL & "NULL" & ","
                'NULLでない時
                Else
                    '申請日のデータを移行
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI("apply_date") & "',"
                End If
                '認定日のデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI("fixed_date")) Then
                    '「NULL」文字を移行
                    strNinteiSQL = strNinteiSQL & "NULL" & ","
                'NULL以外
                Else
                    '認定日のデータを移行
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI("fixed_date") & "',"
                End If
                '有効期間開始のデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI("valid_from")) Then
                    '「NULL」文字を移行
                    strNinteiSQL = strNinteiSQL & "'0001-01-01',"
                'NULLでない時
                Else
                    '有効期間開始のデータを移行
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI("valid_from") & "',"
                End If
                '有効期間終了のデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI("valid_thru")) Then
                    '「NULL」文字を移行
                    strNinteiSQL = strNinteiSQL & "'" & Format("9999-12-31", "yyyy/mm/dd") & "',"
                'NULL以外
                Else
                    '有効期間終了のデータを移行
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI("valid_thru") & "',"
                End If
                '中断年月のデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI("broken_off_date")) Then
                    '「NULL」文字を移行
                    strNinteiSQL = strNinteiSQL & "NULL" & ","
                'NULL以外
                Else
                    '中断年月のデータを移行
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI("broken_off_date") & "',"
                End If
                '中断理由のデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI("broken_off_reason")) Then
                    '「0」を移行
                    strNinteiSQL = strNinteiSQL & "0,"
                'NULL以外
                Else
                    '中断理由のデータを移行
                    strNinteiSQL = strNinteiSQL & recNINTEIRIREKI("broken_off_reason") & ","
                End If
                '居宅サービス計画作成依頼届出日のデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI("reported_date")) Then
                    '「NULL」文字のデータを移行
                    strNinteiSQL = strNinteiSQL & "NULL" & ","
                'NULL以外
                Else
                    '居宅サービス計画作成依頼届出日のデータを移行
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI("reported_date") & "',"
                End If
                '支給限度額のデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI("provision_limit1")) Then
                    '「0」をデータを移行
                    strNinteiSQL = strNinteiSQL & "0,"
                Else
                    '支給限度額のデータを移行
                    strNinteiSQL = strNinteiSQL & recNINTEIRIREKI("provision_limit1") & ","
                End If
                '外部利用型支給限度額のデータを移行
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
                '最終更新日にシステム日付を登録
                strNinteiSQL = strNinteiSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
                strNinteiSQL = strNinteiSQL & ")"
                
                Call FDBExecuteSQL(strNinteiSQL)

            '認定履歴の有効期間が空でデータがある時
            ElseIf Not recNINTEIRIREKI_COUNT.EOF Then
                '認定履歴情報テーブルを移行
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
                '利用者番号のデータを移行
                strNinteiSQL = strNinteiSQL & recPATIENT("pat_id") & ","
                '認定履歴番号に「1」を登録
                strNinteiSQL = strNinteiSQL & "'" & 1 & "',"
                '保険者番号のデータを移行
                'NULLの時
                If IsNull(recPATIENT("insr_no")) Then
                    '空のデータを移行
                    strNinteiSQL = strNinteiSQL & "'',"
                Else
                    '移行元のデータを移行（シングルクォートと置換）
                    strNinteiSQL = strNinteiSQL & "'" & Replace(recPATIENT("insr_no"), "'", "''") & "',"
                End If
                '被保険者番号のデータ移行
                If IsNull(recPATIENT("insd_no")) Then
                    '空のデータを移行
                    strNinteiSQL = strNinteiSQL & "'',"
                Else
                    '移行元のデータを移行（シングルクォートと置換）
                    strNinteiSQL = strNinteiSQL & "'" & Replace(recPATIENT("insd_no"), "'", "''") & "',"
                End If
                '給付率のデータを移行
                strNinteiSQL = strNinteiSQL & recPATIENT("ins_rate") & ","
                '居宅計画作成者のデータを移行
                'NULLの時
                If IsNull(recPATIENT("planner")) Then
                    '「0」を移行
                    strNinteiSQL = strNinteiSQL & "0,"
                'NULLでない時
                Else
                    '居宅計画作成者のデータを移行
                    strNinteiSQL = strNinteiSQL & recPATIENT("planner") & ","
                End If
                '居宅サービス作成事業所番号のデータを移行
                strNinteiSQL = strNinteiSQL & "'" & recPATIENT("planner_no") & "',"
                '申請種別コードのデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI_COUNT("apply_type")) Then
                    '「0」を移行
                    strNinteiSQL = strNinteiSQL & "0,"
                'NULLでない時
                Else
                    '申請種別コードのデータを移行
                    strNinteiSQL = strNinteiSQL & recNINTEIRIREKI_COUNT("apply_type") & ","
                End If
                '申請中コードのデータ移行
                'NULLの時
                If IsNull(recNINTEIRIREKI_COUNT("change_apply")) Then
                    '「0」を移行
                    strNinteiSQL = strNinteiSQL & "0,"
                'NULLでない時
                Else
                    '移行元データが「2」時
                    If recNINTEIRIREKI_COUNT("change_apply") = 2 Then
                        '「1」を移行
                        strNinteiSQL = strNinteiSQL & "1,"
                    '「2」以外のとき
                    Else
                        '「0」を移行
                        strNinteiSQL = strNinteiSQL & "0,"
                    End If
                End If
                '要介護状態区分コードのデータを移行
                strNinteiSQL = strNinteiSQL & recNINTEIRIREKI_COUNT("nurs_stat") & ","
                '申請日のデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI_COUNT("apply_date")) Then
                    '「NULL」文字を登録
                    strNinteiSQL = strNinteiSQL & "NULL" & ","
                'NULLでない時
                Else
                    '申請日のデータを移行
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI_COUNT("apply_date") & "',"
                End If
                '認定日のデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI_COUNT("fixed_date")) Then
                    '「NULL」文字を移行
                    strNinteiSQL = strNinteiSQL & "NULL" & ","
                'NULL以外
                Else
                    '認定日のデータを移行
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI_COUNT("fixed_date") & "',"
                End If
                '有効期間開始のデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI_COUNT("valid_from")) Then
                    '「NULL」文字を移行
                    strNinteiSQL = strNinteiSQL & "'0001-01-01',"
                'NULLでない時
                Else
                    '有効期間開始のデータを移行
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI_COUNT("valid_from") & "',"
                End If
                '有効期間終了のデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI_COUNT("valid_thru")) Then
                    '「NULL」文字を移行
                    strNinteiSQL = strNinteiSQL & "'" & Format("9999-12-31", "yyyy/mm/dd") & "',"
                'NULL以外
                Else
                    '有効期間終了のデータを移行
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI_COUNT("valid_thru") & "',"
                End If
                '中断年月のデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI_COUNT("broken_off_date")) Then
                    '「NULL」文字を移行
                    strNinteiSQL = strNinteiSQL & "NULL" & ","
                'NULL以外
                Else
                    '中断年月のデータを移行
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI_COUNT("broken_off_date") & "',"
                End If
                '中断理由のデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI_COUNT("broken_off_reason")) Then
                    '「0」を移行
                    strNinteiSQL = strNinteiSQL & "0,"
                'NULL以外
                Else
                    '中断理由のデータを移行
                    strNinteiSQL = strNinteiSQL & recNINTEIRIREKI_COUNT("broken_off_reason") & ","
                End If
                '居宅サービス計画作成依頼届出日のデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI_COUNT("reported_date")) Then
                    '「NULL」文字のデータを移行
                    strNinteiSQL = strNinteiSQL & "NULL" & ","
                'NULL以外
                Else
                    '居宅サービス計画作成依頼届出日のデータを移行
                    strNinteiSQL = strNinteiSQL & "'" & recNINTEIRIREKI_COUNT("reported_date") & "',"
                End If
                '支給限度額のデータを移行
                'NULLの時
                If IsNull(recNINTEIRIREKI_COUNT("provision_limit1")) Then
                    '「0」をデータを移行
                    strNinteiSQL = strNinteiSQL & "0,"
                Else
                    '支給限度額のデータを移行
                    strNinteiSQL = strNinteiSQL & recNINTEIRIREKI_COUNT("provision_limit1") & ","
                End If
                '外部利用型支給限度額のデータを移行
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
                '最終更新日にシステム日付を登録
                strNinteiSQL = strNinteiSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
                strNinteiSQL = strNinteiSQL & ")"
            
                Call FDBExecuteSQL(strNinteiSQL)
            
            End If
    
        recPATIENT.MoveNext
    Loop
    
    Exit Sub
    
Err_Connection:

    MsgBox "データの移行に失敗しました。" & vbNewLine & "申し訳ありませんが、データの移行をはじめからやり直してください。" _
    , vbInformation + vbOKOnly, "データ移行失敗"
    
    End

End Sub

Public Sub ConvPROVIDER()
'============================================================================================
'事業者情報移行（全共通）
'============================================================================================
Dim strSQL As String
Dim strSQLStaff As String
Dim varTel As Variant
Dim varFax As Variant
Dim varStaff As Variant
Dim varStaffName As Variant
Dim recPROVIDER As Object

    'エラー処理
    On Error GoTo Err_Connection

    '事業者情報テーブルの取得
    Set recPROVIDER = MDBExecuteRecordSet("SELECT * FROM m_pvd", adOpenForwardOnly, adLockReadOnly)
    
    '事業者情報数分処理を回す
    Do Until recPROVIDER.EOF
        'スタッフ情報のデータを移行
        'スタッフデータが空でない時
        If recPROVIDER("pvd_man_nm") <> "" Then
            varStaff = Split(recPROVIDER("pvd_man_nm"), Chr(9))
            Dim i
            For i = 0 To UBound(varStaff)
                'スタッフ氏名を分割
                If InStr(varStaff(i), " ") <> 0 Then
                    varStaffName = Split(varStaff(i), " ")
                ElseIf InStr(varStaff(i), "　") <> 0 Then
                    varStaffName = Split(varStaff(i), "　")
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
                '事業所番号のデータを移行
                strSQLStaff = strSQLStaff & "'" & recPROVIDER("pvd_no") & "',"
                'スタッフ番号にi+1を登録
                strSQLStaff = strSQLStaff & i + 1 & ","
                'スタッフ氏名の姓に分割したデータの最初を移行
                If InStr(varStaff(i), " ") <> 0 Or InStr(varStaff(i), "　") <> 0 Then
                    'NULLでない時
                    If IsNull(varStaffName(0)) Then
                        strSQLStaff = strSQLStaff & "'',"
                    Else
                        '移行元のデータを移行（シングルクォートを置換）
                        strSQLStaff = strSQLStaff & "'" & Replace(varStaffName(0), "'", "''") & "',"
                    End If
                Else
                    'NULLでない時
                    If IsNull(varStaffName) Then
                        strSQLStaff = strSQLStaff & "'',"
                    Else
                        '移行元のデータを移行（シングルクォートを置換）
                        strSQLStaff = strSQLStaff & "'" & Replace(varStaffName, "'", "''") & "',"
                    End If
                End If
                'スタッフ氏名の姓に分割したデータの最初を移行
                '分割したデータが0以上の時
                If InStr(varStaff(i), " ") > 0 Then
                    'NULLでない時
                    If IsNull(varStaffName(1)) Then
                        strSQLStaff = strSQLStaff & "'',"
                    Else
                        '移行元のデータを移行（シングルクォートを置換）
                        strSQLStaff = strSQLStaff & "'" & Replace(varStaffName(1), "'", "''") & "',"
                    End If
                ElseIf InStr(varStaff(i), "　") > 0 Then
                    'NULLでないとき
                    If IsNull(varStaffName(1)) Then
                        strSQLStaff = strSQLStaff & "'',"
                    Else
                        strSQLStaff = strSQLStaff & "'" & Replace(varStaffName(1), "'", "''") & "',"
                    End If
                Else
                    strSQLStaff = strSQLStaff & "'',"
                End If
                '最終更新日にシステム日付を登録
                strSQLStaff = strSQLStaff & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
                strSQLStaff = strSQLStaff & ")"
                
                Call FDBExecuteSQL(strSQLStaff)
            Next i
        
        End If
    
        '電話番号/FAX番号をハイフンで分割
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
        
        '事業所情報テーブルを移行
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
        '事業所番号のデータを移行
        strSQL = strSQL & "'" & recPROVIDER("pvd_no") & "',"
        '事業所種別に「0」を登録
        strSQL = strSQL & "0,"
        '医療機関フラグに「0」を登録
        strSQL = strSQL & "0,"
        '事業所名のデータを移行
        'NULLの時
        If IsNull(recPROVIDER("pvd_nm")) Then
            strSQL = strSQL & "'',"
        Else
            '移行元のデータを移行（シングルクォートを置換）
            strSQL = strSQL & "'" & Replace(recPROVIDER("pvd_nm"), "'", "''") & "',"
        End If
        '郵便番号のデータを移行
        'NULLの時
        If IsNull(recPROVIDER("pvd_zip_code")) Then
            '空データを2個移行
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        '移行元のデータの長さが3以上の時
        ElseIf Len(recPROVIDER("pvd_zip_code")) > 3 Then
            '左から3桁のデータを移行
            strSQL = strSQL & "'" & Left$(recPROVIDER("pvd_zip_code"), 3) & "',"
            '4桁からデータの最終までを移行
            strSQL = strSQL & "'" & Mid$(recPROVIDER("pvd_zip_code"), 4, Len(recPROVIDER("pvd_zip_code"))) & "',"
        '上記以外
        Else
            '左から3桁のデータを移行
            strSQL = strSQL & "'" & Left$(recPROVIDER("pvd_zip_code"), 3) & "',"
            '空のデータを移行
            strSQL = strSQL & "'',"
        End If
        '住所のデータを移行
        If IsNull(recPROVIDER("pvd_address")) Then
            strSQL = strSQL & "'',"
        Else
            '移行元のデータを移行（シングルクォートを置換）
            strSQL = strSQL & "'" & Replace(recPROVIDER("pvd_address"), "'", "''") & "',"
        End If
        '電話番号のデータを移行
        'NULLの時
        If IsNull(recPROVIDER("pvd_tel")) Then
            '空のデータを3個移行
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        'ハイフンで分割したデータが0個以外のとき
        ElseIf InStr(recPROVIDER("pvd_tel"), "-") <> 0 Then
            '数値型のチェック
            If IsNumeric(varTel(0)) = True Then
                '左から6桁のデータを移行
                strSQL = strSQL & "'" & Left$(varTel(0), 6) & "',"
            '数値型でないとき
            Else
                '空のデータを移行
                strSQL = strSQL & "'',"
            End If
            '分割したデータの0個以上
            If UBound(varTel) > 0 Then
                '数値型の時
                If IsNumeric(varTel(1)) = True Then
                    'NULLで無い時、左から4桁のデータを移行
                    If Not IsNull(varTel(1)) Then
                        strSQL = strSQL & "'" & Left$(varTel(1), 4) & "',"
                    'NULLの時
                    Else
                        '空のデータを移行
                        strSQL = strSQL & "'',"
                    End If
                '数値型でないとき
                Else
                    '空のデータを移行
                    strSQL = strSQL & "'',"
                End If
            '分割したデータが0個以下の時
            Else
                '空のデータを移行
                strSQL = strSQL & "'',"
            End If
            '分割したデータが1個以上の時
            If UBound(varTel) > 1 Then
                '数値型のチェック
                If IsNumeric(varTel(2)) = True Then
                    'NULLで無い時
                    If Not IsNull(varTel(2)) Then
                        '左から4桁のデータを移行
                        strSQL = strSQL & "'" & Left$(varTel(2), 4) & "',"
                    Else
                        '空のデータを移行
                        strSQL = strSQL & "'',"
                    End If
                '数値型でないとき
                Else
                    '空のデータを移行
                    strSQL = strSQL & "'',"
                End If
            '分割したデータが1個以下
            Else
                '空のデータを移行
                strSQL = strSQL & "'',"
            End If
        '電話番号がNULLでなく、分割したデータが「0」の時
        Else
            '数値型のチェック
            If IsNumeric(varTel) = True Then
                '左から6桁のデータを移行
                strSQL = strSQL & "'" & Left$(varTel, 6) & "',"
            '数値型でないとき
            Else
                '空のデータを移行
                strSQL = strSQL & "'',"
            End If
            '空のデータを2個移行
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        End If
        'FAX番号のデータを移行
        'NULLの時
        If IsNull(recPROVIDER("pvd_fax")) Then
            '空データを3回移行
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        'ハイフンで区切ったデータの個数が0個以外なら
        ElseIf InStr(recPROVIDER("pvd_fax"), "-") <> 0 Then
            '数値型の時
            If IsNumeric(varFax(0)) = True Then
                '左から6桁を移行
                strSQL = strSQL & "'" & Left$(varFax(0), 6) & "',"
            '数値型以外
            Else
                '空データを移行
                strSQL = strSQL & "'',"
            End If
            '区切ったデータの個数が0個以上
            If UBound(varFax) > 0 Then
                '数値型の時
                If IsNumeric(varFax(1)) = True Then
                    'NULL以外のとき
                    If Not IsNull(varFax(1)) Then
                        '左から4桁のデータを移行
                        strSQL = strSQL & "'" & Left$(varFax(1), 4) & "',"
                    Else
                        '空データを移行
                        strSQL = strSQL & "'',"
                    End If
                Else
                    '空のデータを移行
                    strSQL = strSQL & "'',"
                End If
            '区切ったデータの個数が0個の時
            Else
                '空のデータを移行
                strSQL = strSQL & "'',"
            End If
            'ハイフンで区切ったデータの個数が1個以上
            If UBound(varFax) > 1 Then
                '数値型の時
                If IsNumeric(varFax(2)) = True Then
                    'NULL以外
                    If Not IsNull(varFax(2)) Then
                        '左から4桁のデータを移行
                        strSQL = strSQL & "'" & Left$(varFax(2), 4) & "',"
                    'NULLの時
                    Else
                        '空のデータを移行
                        strSQL = strSQL & "'',"
                    End If
                '数値型でない時
                Else
                    '空のデータを移行
                    strSQL = strSQL & "'',"
                End If
            '区切ったデータの個数が1個以下
            Else
                '空のデータを移行
                strSQL = strSQL & "'',"
            End If
        'NULLでなく、区切りデータが無い時
        Else
            '数値型の時
            If IsNumeric(varFax) = True Then
                '左から6桁を移行
                strSQL = strSQL & "'" & Left$(varFax, 6) & "',"
            '数値型でないとき
            Else
                '空データを移行
                strSQL = strSQL & "'',"
            End If
            '空データを2個移行
            strSQL = strSQL & "'',"
            strSQL = strSQL & "'',"
        End If
        '事業所区分のデータ移行
        '空でない時
        If Not IsNull(recPROVIDER("pvd_self_flg")) Then
            '事業所区分は1と2を入れ替える。
            strSQL = IIf(recPROVIDER("pvd_self_flg") = 1, strSQL & "2,", strSQL & "1,")
        '空の時
        Else
            strSQL = strSQL & "0,"
        End If
        '事業所種別のデータを移行
        strSQL = strSQL & recPROVIDER("designate_type") & ","
        '地域区分が6の時はデータを移行しない。
        strSQL = IIf(recPROVIDER("area_type") = 6, strSQL & "5,", strSQL & recPROVIDER("area_type") & ",")
        '特別地域の1を0にと2を1に入れ替える。
        strSQL = IIf(recPROVIDER("sp_area_flg") = 1, strSQL & "1,", strSQL & "2,")
        '開設者氏名のデータを移行
        'NULLのとき
        If IsNull(recPROVIDER("owner_nm")) Then
            strSQL = strSQL & "'',"
        Else
            '移行元のデータを移行（シングルクォートを置換）
            strSQL = strSQL & "'" & Replace(recPROVIDER("owner_nm"), "'", "''") & "',"
        End If
        '削除フラグのデータを移行
        strSQL = strSQL & "0,"
        '最終更新日にシステム日付を登録
        strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
        strSQL = strSQL & ")"
        
        Call FDBExecuteSQL(strSQL)
    
        recPROVIDER.MoveNext
    Loop
    
    Exit Sub
                                                            
Err_Connection:

    MsgBox "データの移行に失敗しました。" & vbNewLine & "申し訳ありませんが、データの移行をはじめからやり直してください。" _
    , vbInformation + vbOKOnly, "データ移行失敗"
    
    End
                                                            
End Sub

Public Sub ConvPROVIDERSERVICE_Insert(intProviderServiceID As Long, strProviderID As String, intSystemServiceKindDetail As Variant _
                               , intReductRate As Integer)
'============================================================================================
'事業所サービス情報移行（全共通）
'============================================================================================
Dim strSQL As String
                               
    'エラー処理
    On Error GoTo Err_Connection
                               
    '事業所サービス情報テーブルを移行
    strSQL = ""
    strSQL = strSQL & "INSERT INTO PROVIDER_SERVICE ("
    strSQL = strSQL & "PROVIDER_SERVICE_ID,"
    strSQL = strSQL & "PROVIDER_ID,"
    strSQL = strSQL & "SYSTEM_SERVICE_KIND_DETAIL,"
    strSQL = strSQL & "REDUCT_RATE,"
    strSQL = strSQL & "LAST_TIME"
    strSQL = strSQL & ")"
    
    strSQL = strSQL & " VALUES ("
    '事業所サービス番号を登録
    strSQL = strSQL & intProviderServiceID & ","
    '事業所番号を登録
    strSQL = strSQL & "'" & strProviderID & "',"
    'システムサービス種類を登録
    strSQL = strSQL & intSystemServiceKindDetail & ","
    '割引率を登録
    strSQL = strSQL & intReductRate & ","
    '最終更新日にシステム日付を登録
    strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
    strSQL = strSQL & ")"
    
    Call FDBExecuteSQL(strSQL)
    
    Exit Sub

Err_Connection:

    MsgBox "データの移行に失敗しました。" & vbNewLine & "申し訳ありませんが、データの移行をはじめからやり直してください。" _
    , vbInformation + vbOKOnly, "データ移行失敗"
    
    End

End Sub

Public Sub ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID As Long, varSystemBindPath As Variant, intDetailValue As Integer)
'============================================================================================
'事業所サービス詳細情報移行（数値型）
'============================================================================================
Dim strSQL As String
                               
    'エラー処理
    On Error GoTo Err_Connection
                               
    '事業所サービス情報テーブルを移行
    strSQL = ""
    strSQL = strSQL & "INSERT INTO PROVIDER_SERVICE_DETAIL_INTEGER ("
    strSQL = strSQL & "PROVIDER_SERVICE_ID,"
    strSQL = strSQL & "SYSTEM_BIND_PATH,"
    strSQL = strSQL & "DETAIL_VALUE,"
    strSQL = strSQL & "LAST_TIME"
    strSQL = strSQL & ")"
    
    strSQL = strSQL & " VALUES ("
    '事業所サービス番号を登録
    strSQL = strSQL & intProviderServiceID & ","
    'システムバインドパスを登録
    strSQL = strSQL & varSystemBindPath & ","
    'バインドパスの値を登録
    strSQL = strSQL & intDetailValue & ","
    '最終更新日にシステム日付を登録
    strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
    strSQL = strSQL & ")"
    
    Call FDBExecuteSQL(strSQL)
    
    Exit Sub

Err_Connection:

    MsgBox "データの移行に失敗しました。" & vbNewLine & "申し訳ありませんが、データの移行をはじめからやり直してください。" _
    , vbInformation + vbOKOnly, "データ移行失敗"
    
    End

End Sub

Public Sub ConvPROVIDERSERVICEDETAILSQLStr(intProviderServiceID As Long, varSystemBindPath As Variant, strDetailValue As String)
'============================================================================================
'事業所サービス詳細情報移行（文字列型）
'============================================================================================
Dim strSQL As String
                               
    'エラー処理
    On Error GoTo Err_Connection
                               
    '事業所サービス情報テーブルを移行
    strSQL = ""
    strSQL = strSQL & "INSERT INTO PROVIDER_SERVICE_DETAIL_TEXT ("
    strSQL = strSQL & "PROVIDER_SERVICE_ID,"
    strSQL = strSQL & "SYSTEM_BIND_PATH,"
    strSQL = strSQL & "DETAIL_VALUE,"
    strSQL = strSQL & "LAST_TIME"
    strSQL = strSQL & ")"
    
    strSQL = strSQL & " VALUES ("
    '事業所サービス番号のデータを登録
    strSQL = strSQL & intProviderServiceID & ","
    'システムバインドパスを登録
    strSQL = strSQL & varSystemBindPath & ","
    'バインドパスの値を登録
    strSQL = strSQL & "'" & strDetailValue & "',"
    '最終更新日にシステム日付を登録
    strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
    strSQL = strSQL & ")"
    
    Call FDBExecuteSQL(strSQL)
    
    Exit Sub

Err_Connection:

    MsgBox "データの移行に失敗しました。" & vbNewLine & "申し訳ありませんが、データの移行をはじめからやり直してください。" _
    , vbInformation + vbOKOnly, "データ移行失敗"
    
    End

End Sub

Public Sub ConvPROVIDERMENU(varLoginProviderID As Variant, intMenuID As Integer, intShowFlag As Integer)
'============================================================================================
'事業所サービス詳細情報移行（文字列型）
'============================================================================================
Dim strSQL As String
                               
    'エラー処理
    On Error GoTo Err_Connection
                               
    '事業所サービス情報テーブルを移行
    strSQL = ""
    strSQL = strSQL & "INSERT INTO PROVIDER_MENU ("
    strSQL = strSQL & "LOGIN_PROVIDER_ID,"
    strSQL = strSQL & "MENU_ID,"
    strSQL = strSQL & "SHOW_FLAG,"
    strSQL = strSQL & "LAST_TIME"
    strSQL = strSQL & ")"
    
    strSQL = strSQL & " VALUES ("
    'ログイン事業所番号のデータを登録
    strSQL = strSQL & "'" & varLoginProviderID & "',"
    'メニュー番号のデータを登録
    strSQL = strSQL & intMenuID & ","
    '表示フラグを登録
    strSQL = strSQL & intShowFlag & ","
    '最終更新日にシステム日付を登録
    strSQL = strSQL & "'" & Format(gNowDate, "yyyy/mm/dd hh:nn:ss") & "'"
    strSQL = strSQL & ")"
    
    Call FDBExecuteSQL(strSQL)
    
    Exit Sub

Err_Connection:

    MsgBox "データの移行に失敗しました。" & vbNewLine & "申し訳ありませんが、データの移行をはじめからやり直してください。" _
    , vbInformation + vbOKOnly, "データ移行失敗"
    
    End

End Sub

Public Sub ConvPROVIDERSERVICE()
'Public Sub ConvPROVIDERSERVICE(ini As String, iniProviderServiceDetail As String)
'============================================================================================
'事業所サービス情報移行（全共通）
'============================================================================================
Dim intProviderServiceID As Long                     '事業所サービスID
Dim intLogicalAdd As Integer                         '論理和の数
Dim intMMenu As Integer                              'メニューIDの数


Dim recPROVIDERSERVICE As Object                     'サービス情報のレコードセット（旧）
Dim recPROVIDERSERVICENEW As Object                  'サービス情報のレコードセット（新）
Dim recPROVIDERSERVIDEMAX As Object                  'サービス情報の最大値
Dim recMSERVICE As Object                            'サービスマスタ
Dim recMMENU As Object                               'メニューマスタ

'ループ用
Dim i As Integer
Dim j As Integer

'事業所番号のold値
Dim varProviderID_old As Variant
'事業所番号とサービス種類の二次元配列
Dim varProviderIDToSystemKindDetail(1000, 10000) As Variant
'事業所番号の配列
Dim strProviderID(2000) As String
Dim varProviderID As Variant

'論理和
Dim LogicalAdd(1000) As Long
'論理積
Dim LogicalProduct(1000, 10000) As Long
'メニューIDの配列
Dim intMenuID(1000, 10000) As Integer
    
    'エラー処理
    On Error GoTo Err_Connection
    
    '事業所サービス情報テーブルの取得
    Set recPROVIDERSERVICE = MDBExecuteRecordSet("SELECT * FROM m_pvd", adOpenForwardOnly, adLockReadOnly)
    
    '事業所サービスIDの初期値
    intProviderServiceID = 1
    '事業所サービス情報数分処理を回す
    Do Until recPROVIDERSERVICE.EOF
        
'==============================================================================================================================
'訪問介護のデータ移行
        If recPROVIDERSERVICE("svc11_flg") = 2 Then
            '事業所サービス移行
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "11111", recPROVIDERSERVICE("reduce11"))
            
            'Ver3.5の時
            If GetDBVersion = VER35 Then
                '社会福祉軽減措置
                '移行元データが2の時
                If Not IsNull(recPROVIDERSERVICE("svc11_shafuku")) Then
                    If recPROVIDERSERVICE("svc11_shafuku") = 2 Then
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1", "2")
                    End If
                End If
            End If
        
            '事業所サービスIDに1を加える
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'訪問入浴介護のデータ移行
        If recPROVIDERSERVICE("svc12_flg") = 2 Then
            '事業所サービス移行
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "11211", recPROVIDERSERVICE("reduce12"))
        
            '事業所サービスIDに1を加える
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'訪問看護のデータ移行
        If recPROVIDERSERVICE("svc13_flg") = 2 Then
            '事業所サービス移行
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "11311", recPROVIDERSERVICE("reduce13"))
            
            '施設区分を移行
            If Not IsNull(recPROVIDERSERVICE("svc13_est")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1130101", recPROVIDERSERVICE("svc13_est"))
            End If
            '特別管理体制を移行
            If Not IsNull(recPROVIDERSERVICE("svc13_sp_management")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1130102", recPROVIDERSERVICE("svc13_sp_management"))
            End If
            '管理者氏名を移行
            If Not IsNull(recPROVIDERSERVICE("svc00_manager_nm")) Then
                Call ConvPROVIDERSERVICEDETAILSQLStr(intProviderServiceID, "1130103", Replace(recPROVIDERSERVICE("svc00_manager_nm"), "'", "''"))
            End If
            '緊急時訪問看護体制を移行
            If Not IsNull(recPROVIDERSERVICE("svc13_emergency")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1130104", recPROVIDERSERVICE("svc13_emergency"))
            End If
            'Ver2.0の時は、（医療）分のデータも移行
            If GetDBVersion = VER20 Then
                '医療保険ステーションコードを移行
                If Not IsNull(recPROVIDERSERVICE("svc00_station_cd")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLStr(intProviderServiceID, "2010101", Replace(recPROVIDERSERVICE("svc00_station_cd"), "'", "''"))
                End If
                '24時間連絡体制加算のデータを移行
                If Not IsNull(recPROVIDERSERVICE("svc00_24h")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLStr(intProviderServiceID, "2010102", recPROVIDERSERVICE("svc00_24h"))
                End If
                '重症者管理加算のデータを移行
                If Not IsNull(recPROVIDERSERVICE("svc00_serious_disease")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLStr(intProviderServiceID, "2010103", recPROVIDERSERVICE("svc00_serious_disease"))
                End If
            End If
            
            '事業所サービスIDに1を加える
            intProviderServiceID = intProviderServiceID + 1
            
            'Ver2.0の時は、（医療）分のデータも移行
            If GetDBVersion = VER20 Then
                '事業所サービス移行
                Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
                "20101", recPROVIDERSERVICE("reduce13"))
                
                '施設区分を移行
                If Not IsNull(recPROVIDERSERVICE("svc13_est")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1130101", recPROVIDERSERVICE("svc13_est"))
                End If
                '特別管理体制を移行
                If Not IsNull(recPROVIDERSERVICE("svc13_sp_management")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1130102", recPROVIDERSERVICE("svc13_sp_management"))
                End If
                '管理者氏名を移行
                If Not IsNull(recPROVIDERSERVICE("svc00_manager_nm")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLStr(intProviderServiceID, "1130103", recPROVIDERSERVICE("svc00_manager_nm"))
                End If
                '緊急時訪問看護体制を移行
                If Not IsNull(recPROVIDERSERVICE("svc13_emergency")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1130104", recPROVIDERSERVICE("svc13_emergency"))
                End If
                '医療保険ステーションコードを移行
                If Not IsNull(recPROVIDERSERVICE("svc00_station_cd")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLStr(intProviderServiceID, "2010101", recPROVIDERSERVICE("svc00_station_cd"))
                End If
                
            End If
        
            '事業所サービスIDに1を加える
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
       
'==============================================================================================================================
'訪問リハのデータ移行
        If recPROVIDERSERVICE("svc14_flg") = 2 Then
            '事業所サービス移行
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "11411", recPROVIDERSERVICE("reduce14"))
        
            'Ver3.5の時
            If GetDBVersion = VER35 Then
                '施設区分を移行
                If Not IsNull(recPROVIDERSERVICE("svc14_est")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1140101", recPROVIDERSERVICE("svc14_est"))
                End If
            End If
            
            '事業所サービスIDに1を加える
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'通所介護のデータ移行
        If recPROVIDERSERVICE("svc15_flg") = 2 Then
            '事業所サービス移行
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "11511", recPROVIDERSERVICE("reduce15"))
        
            '個別機能訓練指導体制を移行
            If Not IsNull(recPROVIDERSERVICE("svc15_training")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1150102", recPROVIDERSERVICE("svc15_training"))
            End If
            '入浴介助体制を移行
            If Not IsNull(recPROVIDERSERVICE("svc15_bath")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1150103", recPROVIDERSERVICE("svc15_bath"))
            End If
            
            'Ver3.5の時
            If GetDBVersion = VER35 Then
                '社会福祉軽減措置
                '移行元データが2の時
                If Not IsNull(recPROVIDERSERVICE("svc15_shafuku")) Then
                    If recPROVIDERSERVICE("svc15_shafuku") = 2 Then
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1", "2")
                    End If
                End If
            End If
        
            '事業所サービスIDに1を加える
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'通所リハのデータ移行
        If recPROVIDERSERVICE("svc16_flg") = 2 Then
            '事業所サービス移行
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "11611", recPROVIDERSERVICE("reduce16"))
        
            '施設区分を移行
            If Not IsNull(recPROVIDERSERVICE("svc16_est")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1160101", recPROVIDERSERVICE("svc16_est"))
            End If

            '入浴介助体制を移行
            If Not IsNull(recPROVIDERSERVICE("svc16_bath")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1160102", recPROVIDERSERVICE("svc16_bath"))
            End If

            '事業所サービスIDに1を加える
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'福祉用具のデータ移行
        If recPROVIDERSERVICE("svc17_flg") = 2 Then
            '事業所サービス移行
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "11711", recPROVIDERSERVICE("reduce17"))
       
            '事業所サービスIDに1を加える
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'短期入所生活介護のデータ移行
        If recPROVIDERSERVICE("svc21_flg") = 2 Then
            '事業所サービス移行
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "12111", recPROVIDERSERVICE("reduce21"))
      
            '施設区分を移行
            If Not IsNull(recPROVIDERSERVICE("svc21_est")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1210101", recPROVIDERSERVICE("svc21_est"))
            End If
            '夜間勤務条件基準を移行
            If Not IsNull(recPROVIDERSERVICE("svc21_nw")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1210102", recPROVIDERSERVICE("svc21_nw"))
            End If
            '機能訓練指導体制を移行
            If Not IsNull(recPROVIDERSERVICE("svc21_training")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1210103", recPROVIDERSERVICE("svc21_training"))
            End If
            '送迎体制を移行
            If Not IsNull(recPROVIDERSERVICE("svc21_ws")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1210104", recPROVIDERSERVICE("svc21_ws"))
            End If

            'Ver3.5の時
            If GetDBVersion = VER35 Then
                '栄養管理体制を移行
                If Not IsNull(recPROVIDERSERVICE("svc21_eiyoukanri")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1210105", recPROVIDERSERVICE("svc21_eiyoukanri"))
                End If
                '社会福祉軽減措置
                '移行元データが2の時
                If Not IsNull(recPROVIDERSERVICE("svc21_shafuku")) Then
                    If recPROVIDERSERVICE("svc21_shafuku") = 2 Then
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1", "2")
                    End If
                End If
            End If

            '事業所サービスIDに1を加える
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'短期入所療養介護（老健）のデータ移行
        If recPROVIDERSERVICE("svc22_flg") = 2 Then
            '事業所サービス移行
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "12211", recPROVIDERSERVICE("reduce22"))
                
            '夜間勤務条件基準を移行
            If Not IsNull(recPROVIDERSERVICE("svc22_nw")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1220102", recPROVIDERSERVICE("svc22_nw"))
            End If
            'リハビリ機能強化体制を移行
            If Not IsNull(recPROVIDERSERVICE("svc22_reha")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1220103", recPROVIDERSERVICE("svc22_reha"))
            End If
            '送迎体制を移行
            If Not IsNull(recPROVIDERSERVICE("svc22_ws")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1220105", recPROVIDERSERVICE("svc22_ws"))
            End If
        
            'Ver3.5の時
            If GetDBVersion = VER35 Then
                '施設区分を移行
                If Not IsNull(recPROVIDERSERVICE("svc22_unit")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1220101", recPROVIDERSERVICE("svc22_unit"))
                End If
                '栄養管理体制を移行
                If Not IsNull(recPROVIDERSERVICE("svc22_eiyoukanri")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1220106", recPROVIDERSERVICE("svc22_eiyoukanri"))
                End If
            End If
        
            '事業所サービスIDに1を加える
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'短期入所療養介護（病院）のデータ移行
        If recPROVIDERSERVICE("svc23_rh_flg") = 2 Then
            '事業所サービス移行
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "12311", recPROVIDERSERVICE("reduce23"))
       
            '人員配置区分を移行
            If Not IsNull(recPROVIDERSERVICE("svc23_rh_staff")) Then
                 Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230102", recPROVIDERSERVICE("svc23_rh_staff"))
            End If
            '療養環境基準を移行
            If Not IsNull(recPROVIDERSERVICE("svc23_rh_env")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230104", recPROVIDERSERVICE("svc23_rh_env"))
            End If
            '医師の配置基準を移行
            If Not IsNull(recPROVIDERSERVICE("svc23_rh_dr")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230105", recPROVIDERSERVICE("svc23_rh_dr"))
            End If
            '送迎体制を移行
            If Not IsNull(recPROVIDERSERVICE("svc23_rh_ws")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230106", recPROVIDERSERVICE("svc23_rh_ws"))
            End If
        
        
            'Ver2.0の時
            If GetDBVersion = VER20 Then
               '施設区分を移行
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230101", "1")
                '夜間勤務条件基準を移行
                '移行元データが「5」の時
                If Not IsNull(recPROVIDERSERVICE("svc23_rh_nw")) Then
                    If recPROVIDERSERVICE("svc23_rh_nw") = 5 Then
                        'なにもしない
                    '移行元データが「6」の時
                    ElseIf recPROVIDERSERVICE("svc23_rh_nw") = 6 Then
                        '「5」を移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230103", "5")
                    '上記以外
                    Else
                        '夜間勤務条件基準を移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230103", recPROVIDERSERVICE("svc23_rh_nw"))
                    End If
                End If
            'Ver3.5の時
            ElseIf GetDBVersion = VER35 Then
                '施設区分を移行
                If Not IsNull(recPROVIDERSERVICE("svc23_rh_unit")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230101", recPROVIDERSERVICE("svc23_rh_unit"))
                End If
                '夜間勤務条件基準を移行
                If Not IsNull(recPROVIDERSERVICE("svc23_rh_nw")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230103", recPROVIDERSERVICE("svc23_rh_nw"))
                End If
                '栄養管理体制を移行
                If Not IsNull(recPROVIDERSERVICE("svc23_rh_eiyoukanri")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230107", recPROVIDERSERVICE("svc23_rh_eiyoukanri"))
                End If
            End If
        
            '事業所サービスIDに1を加える
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'短期入所療養介護（診療所）のデータ移行
        If recPROVIDERSERVICE("svc23_rc_flg") = 2 Then
            '事業所サービス移行
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "12312", recPROVIDERSERVICE("reduce23"))
       
            '人員配置区分を移行
            If Not IsNull(recPROVIDERSERVICE("svc23_rc_staff")) Then
                 Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230202", recPROVIDERSERVICE("svc23_rc_staff"))
            End If
            '療養環境基準を移行
            If Not IsNull(recPROVIDERSERVICE("svc23_rc_env")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230203", recPROVIDERSERVICE("svc23_rc_env"))
            End If
            '送迎体制を移行
            If Not IsNull(recPROVIDERSERVICE("svc23_rc_ws")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230204", recPROVIDERSERVICE("svc23_rc_ws"))
            End If
        
            'Ver2.0の時
            If GetDBVersion = VER20 Then
               '施設区分を移行
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230201", "1")
            'Ver3.5の時
            ElseIf GetDBVersion = VER35 Then
                '施設区分を移行
                If Not IsNull(recPROVIDERSERVICE("svc23_rc_unit")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230201", recPROVIDERSERVICE("svc23_rc_unit"))
                End If

                '栄養管理体制を移行
                If Not IsNull(recPROVIDERSERVICE("svc23_rc_eiyoukanri")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230205", recPROVIDERSERVICE("svc23_rc_eiyoukanri"))
                End If
            End If
        
            '事業所サービスIDに1を加える
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'短期入所療養介護（認知症）のデータ移行
        If recPROVIDERSERVICE("svc23_dh_flg") = 2 Then
            '事業所サービス移行
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "12313", recPROVIDERSERVICE("reduce23"))
       
            '人員配置区分を移行
'            If Not IsNull(recPROVIDERSERVICE("svc23_dh_staff")) Then
'                 Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230302", recPROVIDERSERVICE("svc23_dh_staff"))
'            End If
            '送迎体制を移行
            If Not IsNull(recPROVIDERSERVICE("svc23_dh_ws")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230303", recPROVIDERSERVICE("svc23_dh_ws"))
            End If
        
            'Ver2.0の時
            If GetDBVersion = VER20 Then
               '施設区分を移行
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230301", "1")
            'Ver3.5の時
            ElseIf GetDBVersion = VER35 Then
                '施設区分を移行
                If Not IsNull(recPROVIDERSERVICE("svc23_dh_unit")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230301", recPROVIDERSERVICE("svc23_dh_unit"))
                End If

                '栄養管理体制を移行
                If Not IsNull(recPROVIDERSERVICE("svc23_dh_eiyoukanri")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230304", recPROVIDERSERVICE("svc23_dh_eiyoukanri"))
                End If
            End If
        
            '事業所サービスIDに1を加える
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
        
        
'==============================================================================================================================
'短期入所療養介護（基準適合型）のデータ移行
        If recPROVIDERSERVICE("svc23_sc_flg") = 2 Then
            '事業所サービス移行
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "12314", recPROVIDERSERVICE("reduce23"))
       
            '送迎体制を移行
            If Not IsNull(recPROVIDERSERVICE("svc23_sc_ws")) Then
                Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230401", recPROVIDERSERVICE("svc23_sc_ws"))
            End If
            
            'Ver3.5の時
            If GetDBVersion = VER35 Then
                '栄養管理体制を移行
                If Not IsNull(recPROVIDERSERVICE("svc23_sc_eiyoukanri")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1230402", recPROVIDERSERVICE("svc23_sc_eiyoukanri"))
                End If
            End If
        
            '事業所サービスIDに1を加える
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
    
    
'==============================================================================================================================
'居宅療養管理指導のデータ移行
        If recPROVIDERSERVICE("svc31_flg") = 2 Then
            '事業所サービス移行
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "13111", recPROVIDERSERVICE("reduce31"))
   
            '事業所サービスIDに1を加える
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
    
    
'==============================================================================================================================
'居宅介護支援のデータ移行
        If recPROVIDERSERVICE("svc43_flg") = 2 Then
            '事業所サービス移行
            Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
            "14311", recPROVIDERSERVICE("reduce43"))
   
            '事業所サービスIDに1を加える
            intProviderServiceID = intProviderServiceID + 1
        End If
'==============================================================================================================================
    
    
'==================================================================================================================================
'Ver3.5
If GetDBVersion = VER35 Then
    
    '==============================================================================================================================
    '認知症対応型共同生活介護のデータ移行
            If recPROVIDERSERVICE("svc32_flg") = 2 Then
                '事業所サービス移行
                Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
                "13211", recPROVIDERSERVICE("reduce32"))
                
                '人員減算を移行
                If Not IsNull(recPROVIDERSERVICE("svc32_shortage")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1320102", recPROVIDERSERVICE("svc32_shortage"))
                End If
            
                '事業所サービスIDに1を加える
                intProviderServiceID = intProviderServiceID + 1
            End If
    '==============================================================================================================================
    
        
    '==============================================================================================================================
    '特定施設入居者生活介護のデータ移行
            If recPROVIDERSERVICE("svc33_flg") = 2 Then
                '事業所サービス移行
                Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
                "13311", recPROVIDERSERVICE("reduce33"))
                
                '個別機能訓練指導体制を移行
                If Not IsNull(recPROVIDERSERVICE("svc33_training")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1330101", recPROVIDERSERVICE("svc33_training"))
                End If
                '人員減算を移行
                If Not IsNull(recPROVIDERSERVICE("svc33_shortage")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1330102", recPROVIDERSERVICE("svc33_shortage"))
                End If
            
                '事業所サービスIDに1を加える
                intProviderServiceID = intProviderServiceID + 1
            End If
    '==============================================================================================================================
    
    
    '==============================================================================================================================
    '介護老人福祉施設のデータ移行
            If recPROVIDERSERVICE("svc51_flg") = 2 Then
                '事業所サービス移行
                Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
                "15111", recPROVIDERSERVICE("reduce51"))
                
                '施設区分を移行
                If Not IsNull(recPROVIDERSERVICE("svc51_est")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510101", recPROVIDERSERVICE("svc51_est"))
                End If
                '夜間勤務条件基準を移行
                If Not IsNull(recPROVIDERSERVICE("svc51_nw")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510102", recPROVIDERSERVICE("svc51_nw"))
                End If
                '個別機能訓練指導体制を移行
                If Not IsNull(recPROVIDERSERVICE("svc51_training")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510103", recPROVIDERSERVICE("svc51_training"))
                End If
                '常勤専従医師配置を移行
                If Not IsNull(recPROVIDERSERVICE("svc51_dr")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510104", recPROVIDERSERVICE("svc51_dr"))
                End If
                '精神科医師定期的療養指導を移行
                If Not IsNull(recPROVIDERSERVICE("svc51_mental")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510105", recPROVIDERSERVICE("svc51_mental"))
                End If
                '障害者生活支援体制を移行
                If Not IsNull(recPROVIDERSERVICE("svc51_hc")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510106", recPROVIDERSERVICE("svc51_hc"))
                End If
                '栄養管理体制を移行
                '3以下の時
                If Not IsNull(recPROVIDERSERVICE("svc51_eiyoukanri")) Then
                    If recPROVIDERSERVICE("svc51_eiyoukanri") <= 3 Then
                        '栄養管理体制を移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510108", recPROVIDERSERVICE("svc51_eiyoukanri"))
                    '4の時
                    ElseIf recPROVIDERSERVICE("svc51_eiyoukanri") = 4 Then
                        '移行元のデータを「1」に変換してデータを移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510108", "1")
                        '栄養マネジメントに「2」を登録
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510109", "2")
                    '5の時
                    ElseIf recPROVIDERSERVICE("svc51_eiyoukanri") = 5 Then
                        '移行元のデータを「2」に変換してデータを移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510108", "2")
                        '栄養マネジメントに「2」を登録
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510109", "2")
                    '6の時
                    ElseIf recPROVIDERSERVICE("svc51_eiyoukanri") = 6 Then
                        '移行元のデータを「3」に変換してデータを移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510108", "3")
                        '栄養マネジメントに「2」を登録
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510109", "2")
                    End If
                End If
                '人員減算を移行
                If Not IsNull(recPROVIDERSERVICE("svc51_shortage")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1510112", recPROVIDERSERVICE("svc51_shortage"))
                End If
                '社会福祉軽減措置
                '移行元データが2の時
                If Not IsNull(recPROVIDERSERVICE("svc51_shafuku")) Then
                    If recPROVIDERSERVICE("svc51_shafuku") = 2 Then
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1", "2")
                    End If
                End If
            
                '事業所サービスIDに1を加える
                intProviderServiceID = intProviderServiceID + 1
            End If
    '==============================================================================================================================
    
    
    '==============================================================================================================================
    '介護老人保険施設のデータ移行
            If recPROVIDERSERVICE("svc52_flg") = 2 Then
                '事業所サービス移行
                Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
                "15211", recPROVIDERSERVICE("reduce52"))
    
                '施設区分を移行
                If Not IsNull(recPROVIDERSERVICE("svc52_unit")) Then
                    If recPROVIDERSERVICE("svc52_unit") = 2 Then
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520101", "3")
                    Else
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520101", "1")
                    End If
                End If
                '夜間勤務条件基準を移行
                If Not IsNull(recPROVIDERSERVICE("svc52_nw")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520102", recPROVIDERSERVICE("svc52_nw"))
                End If
                '栄養管理体制を移行
                If Not IsNull(recPROVIDERSERVICE("svc52_eiyoukanri")) Then
                    '3以下の時
                    If recPROVIDERSERVICE("svc52_eiyoukanri") <= 3 Then
                        '栄養管理体制を移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520105", recPROVIDERSERVICE("svc52_eiyoukanri"))
                    '4の時
                    ElseIf recPROVIDERSERVICE("svc52_eiyoukanri") = 4 Then
                        '移行元のデータを「1」に変換してデータを移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520105", "1")
                        '栄養マネジメントに「2」を登録
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520106", "2")
                    '5の時
                    ElseIf recPROVIDERSERVICE("svc52_eiyoukanri") = 5 Then
                        '移行元のデータを「2」に変換してデータを移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520105", "2")
                        '栄養マネジメントに「2」を登録
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520106", "2")
                    '6の時
                    ElseIf recPROVIDERSERVICE("svc52_eiyoukanri") = 6 Then
                        '移行元のデータを「3」に変換してデータを移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520105", "3")
                        '栄養マネジメントに「2」を登録
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520106", "2")
                    End If
                End If
                '人員減算を移行
                If Not IsNull(recPROVIDERSERVICE("svc52_shortage")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1520109", recPROVIDERSERVICE("svc52_shortage"))
                End If
                
                '事業所サービスIDに1を加える
                intProviderServiceID = intProviderServiceID + 1
            End If
    '==============================================================================================================================
    
        
    '==============================================================================================================================
    '介護療養型医療施設（病院）のデータ移行
            If recPROVIDERSERVICE("svc53_1_flg") = 2 Then
                '事業所サービス移行
                Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
                "15311", recPROVIDERSERVICE("reduce53"))
    
                '施設区分を移行
                If Not IsNull(recPROVIDERSERVICE("svc53_1_unit")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530101", recPROVIDERSERVICE("svc53_1_unit"))
                End If
                '人員配置区分を移行
                If Not IsNull(recPROVIDERSERVICE("svc53_1_staff")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530102", recPROVIDERSERVICE("svc53_1_staff"))
                End If
                '夜間勤務条件基準を移行
                If Not IsNull(recPROVIDERSERVICE("svc53_1_nw")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530103", recPROVIDERSERVICE("svc53_1_nw"))
                End If
                '療養環境基準を移行
                If Not IsNull(recPROVIDERSERVICE("svc53_1_env")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530104", recPROVIDERSERVICE("svc53_1_env"))
                End If
                '医師の配置基準を移行
                If Not IsNull(recPROVIDERSERVICE("svc53_1_dr")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530105", recPROVIDERSERVICE("svc53_1_dr"))
                End If
                '栄養管理体制を移行
                If Not IsNull(recPROVIDERSERVICE("svc53_1_eiyoukanri")) Then
                    '3以下の時
                    If recPROVIDERSERVICE("svc53_1_eiyoukanri") <= 3 Then
                        '栄養管理体制を移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530106", recPROVIDERSERVICE("svc53_1_eiyoukanri"))
                    '4の時
                    ElseIf recPROVIDERSERVICE("svc53_1_eiyoukanri") = 4 Then
                        '移行元のデータを「1」に変換してデータを移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530106", "1")
                        '栄養マネジメントに「2」を登録
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530107", "2")
                    '5の時
                    ElseIf recPROVIDERSERVICE("svc53_1_eiyoukanri") = 5 Then
                        '移行元のデータを「2」に変換してデータを移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530106", "2")
                        '栄養マネジメントに「2」を登録
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530107", "2")
                    '6の時
                    ElseIf recPROVIDERSERVICE("svc53_1_eiyoukanri") = 6 Then
                        '移行元のデータを「3」に変換してデータを移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530106", "3")
                        '栄養マネジメントに「2」を登録
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530107", "2")
                    End If
                End If
                '人員減算を移行
                If Not IsNull(recPROVIDERSERVICE("svc53_1_shortage")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530110", recPROVIDERSERVICE("svc53_1_shortage"))
                End If

                '特定診療費のデータ移行
                If Not IsNull(recPROVIDERSERVICE("svc53_1_sp_tr")) Then
                    '重症皮膚潰瘍指導管理のデータを移行
                    '移行元データの左から1文字をデータ移行
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "3010101", Left(recPROVIDERSERVICE("svc53_1_sp_tr"), 1))
                    '薬剤管理指導
                    '移行元データの右から1文字をデータ移行
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "3010102", Right(recPROVIDERSERVICE("svc53_1_sp_tr"), 1))
                End If
                
                '事業所サービスIDに1を加える
                intProviderServiceID = intProviderServiceID + 1
            End If
    '==============================================================================================================================
    
    
    '==============================================================================================================================
    '介護療養型医療施設（診療所）のデータ移行
            If recPROVIDERSERVICE("svc53_2_flg") = 2 Then
                '事業所サービス移行
                Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
                "15312", recPROVIDERSERVICE("reduce53"))
    
                '施設区分を移行
                If Not IsNull(recPROVIDERSERVICE("svc53_2_unit")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530201", recPROVIDERSERVICE("svc53_2_unit"))
                End If
                '人員配置区分を移行
                If Not IsNull(recPROVIDERSERVICE("svc53_2_staff")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530202", recPROVIDERSERVICE("svc53_2_staff"))
                End If
                '療養環境基準を移行
                If Not IsNull(recPROVIDERSERVICE("svc53_2_env")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530203", recPROVIDERSERVICE("svc53_2_env"))
                End If
                '栄養管理体制を移行
                If Not IsNull(recPROVIDERSERVICE("svc53_2_eiyoukanri")) Then
                    '3以下の時
                    If recPROVIDERSERVICE("svc53_2_eiyoukanri") <= 3 Then
                        '栄養管理体制を移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530204", recPROVIDERSERVICE("svc53_2_eiyoukanri"))
                    '4の時
                    ElseIf recPROVIDERSERVICE("svc53_2_eiyoukanri") = 4 Then
                        '移行元のデータを「1」に変換してデータを移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530204", "1")
                        '栄養マネジメントに「2」を登録
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530205", "2")
                    '5の時
                    ElseIf recPROVIDERSERVICE("svc53_2_eiyoukanri") = 5 Then
                        '移行元のデータを「2」に変換してデータを移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530204", "2")
                        '栄養マネジメントに「2」を登録
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530205", "2")
                    '6の時
                    ElseIf recPROVIDERSERVICE("svc53_2_eiyoukanri") = 6 Then
                        '移行元のデータを「3」に変換してデータを移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530204", "3")
                        '栄養マネジメントに「2」を登録
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530205", "2")
                    End If
                End If
                '特定診療費のデータ移行
                If Not IsNull(recPROVIDERSERVICE("svc53_2_sp_tr")) Then
                    '重症皮膚潰瘍指導管理のデータを移行
                    '移行元データの左から1文字をデータ移行
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "3010101", Left(recPROVIDERSERVICE("svc53_2_sp_tr"), 1))
                    '薬剤管理指導
                    '移行元データの右から1文字をデータ移行
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "3010102", Right(recPROVIDERSERVICE("svc53_2_sp_tr"), 1))
                End If
                
                '事業所サービスIDに1を加える
                intProviderServiceID = intProviderServiceID + 1
            End If
    '==============================================================================================================================
    
    
    '==============================================================================================================================
    '介護療養型医療施設（認知症疾患型）のデータ移行
            If recPROVIDERSERVICE("svc53_3_flg") = 2 Then
                '事業所サービス移行
                Call ConvPROVIDERSERVICE_Insert(intProviderServiceID, recPROVIDERSERVICE("pvd_no"), _
                "15313", recPROVIDERSERVICE("reduce53"))
    
                '施設区分を移行
                If Not IsNull(recPROVIDERSERVICE("svc53_3_unit")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530301", recPROVIDERSERVICE("svc53_3_unit"))
                End If
                '人員配置区分を移行
'                If Not IsNull(recPROVIDERSERVICE("svc53_3_staff")) Then
'                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530302", recPROVIDERSERVICE("svc53_3_staff"))
'                End If
                '3以下の時
                If Not IsNull(recPROVIDERSERVICE("svc53_3_eiyoukanri")) Then
                    If recPROVIDERSERVICE("svc53_3_eiyoukanri") <= 3 Then
                        '栄養管理体制を移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530303", recPROVIDERSERVICE("svc53_3_eiyoukanri"))
                    '4の時
                    ElseIf recPROVIDERSERVICE("svc53_3_eiyoukanri") = 4 Then
                        '移行元のデータを「1」に変換してデータを移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530303", "1")
                        '栄養マネジメントに「2」を登録
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530304", "2")
                    '5の時
                    ElseIf recPROVIDERSERVICE("svc53_3_eiyoukanri") = 5 Then
                        '移行元のデータを「2」に変換してデータを移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530303", "2")
                        '栄養マネジメントに「2」を登録
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530304", "2")
                    '6の時
                    ElseIf recPROVIDERSERVICE("svc53_3_eiyoukanri") = 6 Then
                        '移行元のデータを「3」に変換してデータを移行
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530303", "3")
                        '栄養マネジメントに「2」を登録
                        Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530304", "2")
                    End If
                End If
                '人員減算を移行
                If Not IsNull(recPROVIDERSERVICE("svc53_3_shortage")) Then
                    Call ConvPROVIDERSERVICEDETAILSQLInt(intProviderServiceID, "1530307", recPROVIDERSERVICE("svc53_3_shortage"))
                End If
                
                '事業所サービスIDに1を加える
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
        '一回目のループ処理のとき、事業所番号のoldを空に設定する。
        If i = 0 And j = 0 Then varProviderID_old = ""
        '事業所番号oldと取得した事業所番号が一致せず、二回目以降のループ処理のとき
        If recPROVIDERSERVICENEW("PROVIDER_ID") <> varProviderID_old And varProviderID_old <> "" Then
            i = i + 1
            '事業所IDの「SystemKindDetail」配列に（事業所ID、SystemKindDetail）を格納
            varProviderIDToSystemKindDetail(i, j) = recPROVIDERSERVICENEW("PROVIDER_ID") & "," & recPROVIDERSERVICENEW("SYSTEM_SERVICE_KIND_DETAIL")
        Else
            '事業所IDの「SystemKindDetail」配列に（事業所ID、SystemKindDetail）を格納
            varProviderIDToSystemKindDetail(i, j) = recPROVIDERSERVICENEW("PROVIDER_ID") & "," & recPROVIDERSERVICENEW("SYSTEM_SERVICE_KIND_DETAIL")
        End If
        '事業所番号のold値の設定
        varProviderID_old = recPROVIDERSERVICENEW("PROVIDER_ID")
        '配列に事業所番号を設定
        strProviderID(i) = recPROVIDERSERVICENEW("PROVIDER_ID")
        j = j + 1
        
        recPROVIDERSERVICENEW.MoveNext
    Loop

    '事業所サービスのデータの個数を取得
    Set recPROVIDERSERVIDEMAX = FDBExecuteRecordSet("SELECT COUNT(*) FROM PROVIDER_SERVICE", adOpenForwardOnly, adLockReadOnly)
    '事業所サービスの個数分ループを回す
    For j = 0 To recPROVIDERSERVIDEMAX(0) - 1
        For intLogicalAdd = 0 To i
            If varProviderIDToSystemKindDetail(intLogicalAdd, j) <> "" Then
                varProviderID = Split(varProviderIDToSystemKindDetail(intLogicalAdd, j), ",")
                Set recMSERVICE = FDBExecuteRecordSet("SELECT * FROM M_SERVICE WHERE SYSTEM_SERVICE_KIND_DETAIL=" & varProviderID(1))
                '論理和
                LogicalAdd(intLogicalAdd) = recMSERVICE("BUSINESS_TYPE") Or LogicalAdd(intLogicalAdd)
            End If
        Next intLogicalAdd
    Next j
    
    Set recMMENU = FDBExecuteRecordSet("SELECT * FROM M_MENU", adOpenForwardOnly, adLockReadOnly)
    
    '論理積を導き出す
    intMMenu = 0
    Do Until recMMENU.EOF
        For i = 0 To intLogicalAdd - 1
            LogicalProduct(i, intMMenu) = recMMENU("BUSINESS_TYPE") And LogicalAdd(i)
            intMenuID(i, intMMenu) = recMMENU("MENU_ID")
        Next i
        intMMenu = intMMenu + 1
        recMMENU.MoveNext
    Loop
    
    '事業所メニューにデータを移行
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

    MsgBox "データの移行に失敗しました。" & vbNewLine & "申し訳ありませんが、データの移行をはじめからやり直してください。" _
    , vbInformation + vbOKOnly, "データ移行失敗"
    
    End

End Sub

Function ReplaceFDBFile(ByVal pstrFilePath As String) As Boolean
'============================================================================================
'指定されたFDBファイルをデータの入っていないFDBファイルと置換する
'============================================================================================
Dim strPath As String
Dim strFilename As String
Dim strZeroFile As String

    ReplaceFDBFile = False

    strZeroFile = App.Path & "\CONVERT.DAT"

    'コピー元のファイルがあるかチェック
    If Dir(strZeroFile) = "" Then
        Call LogWrite(Error, "CONVERT.DATが見つかりません。")
        Exit Function
    End If

    On Error GoTo ERR_SECTION
        strPath = Left$(pstrFilePath, InStrRev(pstrFilePath, "\"))
        strFilename = Dir(pstrFilePath)
        strFilename = Left$(strFilename, InStrRev(strFilename, ".") - 1)

        'ファイルのバックアップを作成
        Name pstrFilePath As strPath & GetBackupFileName(strPath, 0)
        '空白のデータベースファイルをコピー
        Call FileCopy(strZeroFile, pstrFilePath)

        ReplaceFDBFile = True
    On Error GoTo 0

ERR_SECTION:
End Function

Function GetBackupFileName(pstrPath As String, pintCount) As String
'============================================================================================
'退避用のファイル名を取得する
'============================================================================================
Dim strFilaName As String

    If pintCount = 0 Then
        strFilaName = "convert.old"
    Else
        strFilaName = "convert" & CStr(pintCount) & ".old"
    End If

    '同名ファイルが存在する
    If Dir(pstrPath & strFilaName) <> "" Then
        GetBackupFileName = GetBackupFileName(pstrPath, pintCount + 1)
    Else
        GetBackupFileName = strFilaName
    End If

End Function

