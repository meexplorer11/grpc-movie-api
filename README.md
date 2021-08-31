# grpc-movie-api

A simple gRPC Java sample.

It has three modules - client, server, and proto

The server implements a simple unary call with one exception scenario to show how to throw an error/exception.

## How to run

1) Run maven clean install on [grpc-movie-protobuf](https://github.com/meexplorer11/grpc-movie-api/tree/main/grpc-moview-protobuf) to generate the required stubs.

2) Refresh client and server modules

3) Run [MovieServer.java](https://github.com/meexplorer11/grpc-movie-api/blob/main/grpc-movie-server/src/main/java/server/MovieServer.java) to start the server

4) Run [MovieClient.java](https://github.com/meexplorer11/grpc-movie-api/blob/main/grpc-movie-client/src/main/java/client/MovieClient.java) to run the client.