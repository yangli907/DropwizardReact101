const path = require('path');

module.exports = {
    //context: `${__dirname}`,
    entry: './src/app.js',
    output: {
        filename: '[name].bundle.js',
        path: `${__dirname}` + "/src/main/resources/assets",
        publicPath: '/assets/'
    },
    module: {
        loaders: [
            {
                test: /\.js$/,
                loaders: "babel-loader",
                query:
                    {
                        presets:['react']
                    }
            }
        ],
    },
    resolve: {
        extensions: ['.js'],
        alias: {
            components: path.resolve(__dirname, '..', 'src/'),
        }
    },
    resolveLoader: {
        modules: [
            `${__dirname}/`+ "node_modules"
        ]
    }
}