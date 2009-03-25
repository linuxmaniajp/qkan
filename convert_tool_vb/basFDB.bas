Attribute VB_Name = "basDBMS_FDB"
Option Explicit
Private con As Object

Public Function FDBConnection(pstrConnectFile As String, pstrUserId As String, psrtPassword As String) As Boolean
'============================================================================================
'コネクション接続
'============================================================================================
On Error GoTo Err_Connection

        FDBConnection = False

        'ファイルパス確認
        If Trim$(pstrConnectFile) = "" Then
            Exit Function
        End If
        
        'ファイル存在確認
        If Trim$(Dir(pstrConnectFile)) = "" Then
            Exit Function
        End If

        'コネクションオープン
        Set con = CreateObject("ADODB.Connection")
        con.Open "Provider=ZStyle IBOLE Provider;Password=" & psrtPassword & ";User ID=" & pstrUserId & ";Data Source=" & pstrConnectFile & ";"
        
        FDBConnection = True
        
        Exit Function
        
Err_Connection:

    'ログ出力
    Call LogWrite(Error, Err.Description)
    
    Call FDBUnConnection
    
    'FireBirdとの接続用
    Dim dbConection As Boolean
    
    dbConection = False

    On Error GoTo ErrorHandler

    'FireBirdのポートが開かれてるかチェック
    frmM1.Winsock1.Protocol = sckTCPProtocol
    frmM1.Winsock1.LocalPort = "3050"

    frmM1.Winsock1.Connect

    'FireBirdとの接続が確認されたら
    If dbConection = True Then
        MsgBox "給管鳥Ver4.5のデータベースとの接続に失敗しました。" & vbNewLine & VB.App.Path & _
        "の中にある" & vbNewLine & vbNewLine & "「データ移行失敗時に実行用.bat」" & vbNewLine & vbNewLine & "をダブルクリックして、「IBOLE.dllのDllRegisterServerは成功しました。」" & vbNewLine & _
        "が表示されましたら、「OK」ボタンをクリックし、もう一度データ移行を行って下さい。" & vbNewLine & _
        "※「OK」ボタンをクリックするとデータ移行ツールは一旦終了します。", vbOKOnly + vbInformation, "レジストリの登録エラー"
        
        'バッチファイルのあるディレクトリを開く
        Dim lngResult As Long
        lngResult = ShellExecute(frmM1.hwnd, "Explore", App.Path, vbNullString, vbNullString, 9)
        
        End
    'FireBirdとの接続が確認できなければ
    Else
        MsgBox "給管鳥Ver4.5のデータベースとの接続が出来ません。" & vbNewLine & _
        "お使いのPCでセキュリティ対策ソフトウェアをお使いのお客様は、" & vbNewLine & _
        "別途、セキュリティ対策ソフトウェアのマニュアルを読み、ポート：3050を許可する設定を行って下さい。", vbOKOnly + vbExclamation, _
        "データベース接続エラー"

        End
    End If
ErrorHandler:
    dbConection = True
    Resume Next
End Function

Public Function FDBUnConnection()
'============================================================================================
'コネクション解除
'============================================================================================
On Error GoTo Err_UnConnection
    
    con.Close
    Set con = Nothing
    
    Exit Function

Err_UnConnection:

    'ログ出力
    Call LogWrite(Error, Err.Description)

End Function

Public Function FDBExecuteRecordSet(ByVal pstrSQL As String, Optional ByVal plngCursorType As CursorTypeEnum = adOpenForwardOnly, Optional ByVal plngLockType As LockTypeEnum = adLockReadOnly) As Object
'============================================================================================
'レコードセット取得
'============================================================================================
Dim rec As Object

On Error GoTo Err_OpenRecorSet
    
    'レコードセットオブジェクトの生成
    Set rec = CreateObject("ADODB.Recordset")
    'レコードセットのオープン
    rec.Open pstrSQL, con, plngCursorType, plngLockType
    'レコードセットを返す
    Set FDBExecuteRecordSet = rec
    
    Exit Function
        
Err_OpenRecorSet:

    Call LogWrite(Error, Err.Description & "," & pstrSQL)
    Set rec = Nothing

End Function

Public Function FDBExecuteSQL(ByVal pstrSQL As String) As Boolean
'============================================================================================
'SQL文発行処理
'============================================================================================

On Error GoTo Err_Execute

    FDBExecuteSQL = False
        
    con.Execute pstrSQL

    FDBExecuteSQL = True
    Exit Function

Err_Execute:

    Call LogWrite(Error, Err.Description & "," & pstrSQL)

End Function

