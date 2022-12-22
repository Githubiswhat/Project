// see http://vuejs-templates.github.io/webpack for documentation.
var path = require('path')

module.exports = {
    build: {
        env: {NODE_ENV: '"production"'},
        index: path.resolve(__dirname, '../happyfri/index.html'),
        assetsRoot: path.resolve(__dirname, '../happyfri'),
        assetsSubDirectory: 'static',
        assetsPublicPath: '/happyfri/',
        productionSourceMap: true,
        productionGzip: false,
        productionGzipExtensions: ['js', 'css']
    },
    dev: {
        env: {NODE_ENV: '"development"'},
        port: 8088,
        assetsSubDirectory: 'static',
        assetsPublicPath: '/',
        context: [ //代理路径

        ],
        proxypath: 'https://mainsite-restapi.ele.me',

        cssSourceMap: false
    }
}