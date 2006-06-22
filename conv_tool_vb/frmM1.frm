VERSION 5.00
Object = "{F9043C88-F6F2-101A-A3C9-08002B2F49FB}#1.2#0"; "Comdlg32.ocx"
Object = "{248DD890-BB45-11CF-9ABC-0080C7E7B78D}#1.0#0"; "MSWINSCK.OCX"
Begin VB.Form frmM1 
   BorderStyle     =   1  '固定(実線)
   Caption         =   "給管鳥データ移行ツール"
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
   StartUpPosition =   2  '画面の中央
   Begin VB.Frame shiftingFrame 
      Appearance      =   0  'ﾌﾗｯﾄ
      BackColor       =   &H00FFC0C0&
      BorderStyle     =   0  'なし
      ForeColor       =   &H80000008&
      Height          =   1815
      Left            =   120
      TabIndex        =   8
      Top             =   120
      Visible         =   0   'False
      Width           =   7095
      Begin VB.Label ConvMsg 
         Appearance      =   0  'ﾌﾗｯﾄ
         BackColor       =   &H00E0E0E0&
         BeginProperty Font 
            Name            =   "ＭＳ Ｐゴシック"
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
      Caption         =   "移行先FDBファイル"
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
         Caption         =   "※日本語を含むファイルパスは指定しないでください。"
         ForeColor       =   &H000000FF&
         Height          =   270
         Left            =   240
         TabIndex        =   7
         Top             =   720
         Width           =   4290
      End
   End
   Begin VB.Frame fraFrom 
      Caption         =   "移行元QKNファイル"
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
      Caption         =   "開始"
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
        .dlgM1.Filter = "Qknファイル（*.qkn）|*.qkn"
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
        .dlgM1.Filter = "Firebird Database File （*.fdb）|*.fdb"
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
    
        '開始メッセージ
        'edit sta s-fujihara 2005/10/28 データベースファイルを空のファイルに置換する処理を追加
        If MsgBox("データベース移行処理を開始してよろしいですか？" & _
        vbCrLf & "※新バージョン(Ver4.5)に登録されている情報は削除されます。" & vbCrLf & _
        "(旧バージョンの情報に影響はありません）", vbYesNo + vbInformation, MSG_INFO) = vbNo Then
            Exit Sub
        End If
        'edit end s-fujihara 2005/10/28
        
        '移行中メッセージを表示
        shiftingFrame.Visible = True
        ConvMsg.Caption = "給管鳥データ" & vbNewLine & "移行中......"
        frmM1.Refresh
        
        'ログファイルオープン
        Call LogOpen
        
        '処理開始
        Call LogWrite(Info, "======================データベース移行処理開始======================")
    
        'マウスポインタを処理中に変更
        Screen.MousePointer = vbHourglass
    
        'バージョン情報取得
        intVersion = GetDBVersion()
        
        '移行日時を設定
        gNowDate = Now
        
        'edit sta s-fujihara 2005/10/28 データベースファイルを空のファイルに置換する処理を追加
        'バージョンの取得が行えていれば、ファイルの置換処理を行う
        If intVersion <> DBVersion.UNKNOWN Then
            If Not basConvCommon.ReplaceFDBFile(frmM1.txtTo.Text) Then
                strMSG = "データベースファイルの初期化に失敗しました。" & vbCrLf & "給管鳥を実行している場合は終了してください。"
                Call MsgBox(strMSG, vbCritical, MSG_EXCEPTIONSYSTEM)
                Call LogWrite(Error, strMSG)
                'マウスポインタ正常に戻す
                Screen.MousePointer = vbDefault
                'ログファイルクローズ
                Call LogClose
                
                '移行中メッセージを消す
                shiftingFrame.Visible = False

                '終了
                Exit Sub
            End If
        End If
        'edit end s-fujihara 2005/10/28
        
        'バージョンごとに処理を振り分け
        Select Case intVersion
            
            Case DBVersion.VER20
                'ログ出力
                Call LogWrite(Info, "移行元給管鳥バージョン:Ver2.0")
                'Ver1.0移行処理
                Call Conv
            Case DBVersion.VER35
                'ログ出力
                Call LogWrite(Info, "移行元給管鳥バージョン:Ver3.5")
                'Ver3.5移行処理
                Call Conv
            Case DBVersion.UNKNOWN
                strMSG = "移行元の給管鳥システムのバージョン判別に失敗しました。" & vbNewLine & "最新バージョンにアップデートして下さい。"
                Call MsgBox(strMSG, vbCritical, MSG_EXCEPTIONSYSTEM)
                'アプリット社製データベーススキーマ構造変換ツールを起動する。
                'Shell VB.App.Path & "\qkndbupd.exe", vbNormalFocus

                Call LogWrite(Error, strMSG)
                'マウスポインタ正常に戻す
                Screen.MousePointer = vbDefault
                '移行中メッセージを消す
                shiftingFrame.Visible = False
                
                'ログファイルクローズ
                Call LogClose
                '終了
                Exit Sub
        End Select
    
        'マウスポインタ正常に戻す
        Screen.MousePointer = vbDefault
        
        '処理完了
        Call LogWrite(Info, "======================データベース移行処理完了======================")
        
        'ログファイルクローズ
        Call LogClose
        
        '移行中メッセージを消す
        shiftingFrame.Visible = False
        
        '終了メッセージ
        Call MsgBox("データベース移行処理が完了しました。", vbInformation, MSG_INFO)
    
    End If

End Sub

Private Sub Form_Load()
    'アプリケーションのインスタンスが既に実行されているか
    'どうかを示す値を返します。
    If App.PrevInstance = True Then
    'True の場合すでに起動中
        End
    End If

    'IBOLE.dllのレジストリ登録
    Dim ret As Long
    'FireBirdとの接続用
    Dim dbConection As Boolean
    
    ret = Shell("regsvr32 /s " & """" & VB.App.Path & """" & "\IBOLE.dll")

    dbConection = False

    On Error GoTo ErrorHandler

    'FireBirdのポートが開かれてるかチェック
    Winsock1.Protocol = sckTCPProtocol
    Winsock1.LocalPort = "3050"

    Winsock1.Connect

    'FireBirdとの接続が確認されたら
    If dbConection = True Then
        
        Dim ini As String
        'ファイルの存在確認
        Dim strFilename As String
        
        'INIファイルパス取得
        gIniFilePath = VB.App.Path & "\" & VB.App.EXEName & ".ini"
    
        'INIファイル存在確認
        If Dir(gIniFilePath) = "" Then
            Call MsgBox("INIファイルを準備してください。", vbCritical, MSG_EXCEPTIONSYSTEM)
            Unload Me
        End If
    
        'FDBユーザ名取得
        ini = String(511, Chr$(0))
        Call GetPrivateProfileString("FDB", "User", "", ini, Len(ini) + 1, gIniFilePath)
        gFdbUser = Trim$(Replace(ini, Chr$(0), ""))
    
        'FDBパスワード取得
        ini = String(511, Chr$(0))
        Call GetPrivateProfileString("FDB", "Password", "", ini, Len(ini) + 1, gIniFilePath)
        gFdbPassword = Trim$(Replace(ini, Chr$(0), ""))
    
        'qknファイルのデフォルトを設定
        strFilename = VB.App.Path & "\conv.qkn"
        If Not Dir(strFilename, vbNormal Or vbSystem Or vbReadOnly Or vbArchive Or vbHidden) = "" Then
            frmM1.txtFrom.Text = strFilename
        End If
    
        'FDBファイルのデフォルトを設定
        strFilename = VB.App.Path & "\data\QKAN.FDB"
        If Not Dir(strFilename, vbNormal Or vbSystem Or vbReadOnly Or vbArchive Or vbHidden) = "" Then
            frmM1.txtTo.Text = strFilename
        End If
        
        Exit Sub
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
End Sub


Private Sub Form_QueryUnload(Cancel As Integer, UnloadMode As Integer)

    Unload Me

End Sub
