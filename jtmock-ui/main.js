const { app, BrowserWindow, Menu, globalShortcut } = require('electron')

function createWindow () {
    const win = new BrowserWindow({
        width: 800,
        height: 600,
        webPreferences: {
            nodeIntegration: true
        }
    })

    win.loadFile('index.html')
    globalShortcut.register('Alt+Command+J', () => {
        win.webContents.openDevTools({mode:'detach'}) //开启开发者工具
    })
}

app.whenReady().then(createWindow)


const template = [
    {
        label: 'Edit',
        submenu: [
            {role: 'cut'},
            {role: 'copy'},
            {role: 'paste'},
            {role: 'about'}
        ]
    }
]

Menu.setApplicationMenu(Menu.buildFromTemplate(template))

app.on('window-all-closed', () => {
    if (process.platform !== 'darwin') {
        app.quit()
    }
})

app.on('activate', () => {
    if (BrowserWindow.getAllWindows().length === 0) {
        createWindow()
    }
})




