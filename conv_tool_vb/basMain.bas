Attribute VB_Name = "basMain"
Option Explicit

Public Const MSG_EXCEPTIONSYSTEM = "SystemException"
Public Const MSG_EXCEPTIONINFO = "InformationException"
Public Const MSG_INFO = "Information"

Public gCommandLine As String           'コマンドライン退避領域
Public gIniFilePath As String           'INIファイルパス
Public gNowDate As Date                 '移行日時

Public gFdbUser As String               'FDBユーザ名
Public gFdbPassword As String           'FDBパスワード

Public Enum DBVersion
    UNKNOWN = -1
    VER20 = 0
    VER35 = 1
End Enum

Public Function MainCheck() As Boolean
'============================================================================================
'チェック処理
'============================================================================================

    MainCheck = False

    With frmM1
    
        If Trim$(.txtFrom.Text) = "" Then
            Call MsgBox(.fraFrom.Caption & "の場所を正しく指定してください。", vbInformation, MSG_EXCEPTIONINFO)
            .txtFrom.SetFocus
            Exit Function
        End If
    
        If Dir(Trim$(.txtFrom.Text)) = "" Then
            Call MsgBox(.fraFrom.Caption & "に指定されたファイルは存在しません。", vbInformation, MSG_EXCEPTIONINFO)
            .txtFrom.SetFocus
            Exit Function
        End If
    
        If Trim$(.txtTo.Text) = "" Then
            Call MsgBox(.fraTo.Caption & "の場所を正しく指定してください。", vbInformation, MSG_EXCEPTIONINFO)
            .txtTo.SetFocus
            Exit Function
        End If
    
        If Dir(Trim$(.txtTo.Text)) = "" Then
            Call MsgBox(.fraTo.Caption & "に指定されたファイルは存在しません。", vbInformation, MSG_EXCEPTIONINFO)
            .txtTo.SetFocus
            Exit Function
        End If
    
        If Len(Trim$(.txtTo.Text)) <> LenB(StrConv(Trim$(.txtTo.Text), vbFromUnicode)) Then
            Call MsgBox(.fraTo.Caption & "のファイルパスに日本語が含まれています。", vbInformation, MSG_EXCEPTIONINFO)
            .txtTo.SetFocus
            Exit Function
        End If
    
    End With
    
    MainCheck = True

End Function

Public Function GetDBVersion() As DBVersion
'============================================================================================
'DBバージョン情報取得
'============================================================================================
Dim recVERSION As Object
Dim strSQL As String

    GetDBVersion = UNKNOWN
    'コネクション接続
    Call MDBConnection(Trim$(frmM1.txtFrom.Text))
    
    'バージョン情報テーブルの取得
    Set recVERSION = MDBExecuteRecordSet("SELECT [_value] FROM m_db_info WHERE [_section]='db' AND [_key]='version'", adOpenForwardOnly, adLockReadOnly)

    If recVERSION(0) = "2.02.00" Then
        GetDBVersion = VER20
    ElseIf recVERSION(0) = "3.05.00" Then
        GetDBVersion = VER35
    End If

    'コネクション切断
    'Call MDBUnConnection
    
End Function

Public Sub Conv()
'============================================================================================
'移行処理
'============================================================================================
    With frmM1
        'コネクション接続
        Call MDBConnection(Trim$(.txtFrom.Text))
        Call FDBConnection(Trim$(.txtTo.Text), gFdbUser, gFdbPassword)
 
        '保険者情報移行
        Call ConvINSURER
        '短期・施設入所情報移行
        If GetDBVersion = VER35 Then
            Call ConvProviderInfo
        End If
        '患者情報移行
        Call ConvPATIENT
        '事業所情報移行
        Call ConvPROVIDER
        '事業所サービス移行
        Call ConvPROVIDERSERVICE
        
        '居宅療養管理指導書
        Call ConvKYOTAKURYOYO
        '訪問看護計画書
        Call ConvHOMONKANGOPLAN
        '訪問看護報告書
        Call ConvHOMONKANGORESULT
        
        'コネクション切断
        Call MDBUnConnection
        Call FDBUnConnection
    
    End With

End Sub
