module.exports = {
    context: `${__dirname}/`,
    entry: 'app.js',
    output: {
        filename: '[name].bundle.js',
        path: __dirname,
        publicPath: __dirname
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
    resolveLoader: {
        modules: [
            `${__dirname}/`+ "node_modules"
        ]
    }
}