package io.grpc.examples.evotests.datatypes;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: datatypestest.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataTypesTestGrpc {

  private DataTypesTestGrpc() {}

  public static final java.lang.String SERVICE_NAME = "datatypes.DataTypesTest";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.GetInfo,
      io.grpc.examples.evotests.datatypes.SimpleObj> getGetSimpleObjMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getSimpleObj",
      requestType = io.grpc.examples.evotests.datatypes.GetInfo.class,
      responseType = io.grpc.examples.evotests.datatypes.SimpleObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.GetInfo,
      io.grpc.examples.evotests.datatypes.SimpleObj> getGetSimpleObjMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.GetInfo, io.grpc.examples.evotests.datatypes.SimpleObj> getGetSimpleObjMethod;
    if ((getGetSimpleObjMethod = DataTypesTestGrpc.getGetSimpleObjMethod) == null) {
      synchronized (DataTypesTestGrpc.class) {
        if ((getGetSimpleObjMethod = DataTypesTestGrpc.getGetSimpleObjMethod) == null) {
          DataTypesTestGrpc.getGetSimpleObjMethod = getGetSimpleObjMethod =
              io.grpc.MethodDescriptor.<io.grpc.examples.evotests.datatypes.GetInfo, io.grpc.examples.evotests.datatypes.SimpleObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getSimpleObj"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.evotests.datatypes.GetInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.evotests.datatypes.SimpleObj.getDefaultInstance()))
              .setSchemaDescriptor(new DataTypesTestMethodDescriptorSupplier("getSimpleObj"))
              .build();
        }
      }
    }
    return getGetSimpleObjMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.GetInfo,
      io.grpc.examples.evotests.datatypes.NestedObj> getGetNestedObjMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getNestedObj",
      requestType = io.grpc.examples.evotests.datatypes.GetInfo.class,
      responseType = io.grpc.examples.evotests.datatypes.NestedObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.GetInfo,
      io.grpc.examples.evotests.datatypes.NestedObj> getGetNestedObjMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.GetInfo, io.grpc.examples.evotests.datatypes.NestedObj> getGetNestedObjMethod;
    if ((getGetNestedObjMethod = DataTypesTestGrpc.getGetNestedObjMethod) == null) {
      synchronized (DataTypesTestGrpc.class) {
        if ((getGetNestedObjMethod = DataTypesTestGrpc.getGetNestedObjMethod) == null) {
          DataTypesTestGrpc.getGetNestedObjMethod = getGetNestedObjMethod =
              io.grpc.MethodDescriptor.<io.grpc.examples.evotests.datatypes.GetInfo, io.grpc.examples.evotests.datatypes.NestedObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getNestedObj"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.evotests.datatypes.GetInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.evotests.datatypes.NestedObj.getDefaultInstance()))
              .setSchemaDescriptor(new DataTypesTestMethodDescriptorSupplier("getNestedObj"))
              .build();
        }
      }
    }
    return getGetNestedObjMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.SimpleObj,
      io.grpc.examples.evotests.datatypes.NestedObj> getSetNestedObjMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setNestedObj",
      requestType = io.grpc.examples.evotests.datatypes.SimpleObj.class,
      responseType = io.grpc.examples.evotests.datatypes.NestedObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.SimpleObj,
      io.grpc.examples.evotests.datatypes.NestedObj> getSetNestedObjMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.SimpleObj, io.grpc.examples.evotests.datatypes.NestedObj> getSetNestedObjMethod;
    if ((getSetNestedObjMethod = DataTypesTestGrpc.getSetNestedObjMethod) == null) {
      synchronized (DataTypesTestGrpc.class) {
        if ((getSetNestedObjMethod = DataTypesTestGrpc.getSetNestedObjMethod) == null) {
          DataTypesTestGrpc.getSetNestedObjMethod = getSetNestedObjMethod =
              io.grpc.MethodDescriptor.<io.grpc.examples.evotests.datatypes.SimpleObj, io.grpc.examples.evotests.datatypes.NestedObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setNestedObj"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.evotests.datatypes.SimpleObj.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.evotests.datatypes.NestedObj.getDefaultInstance()))
              .setSchemaDescriptor(new DataTypesTestMethodDescriptorSupplier("setNestedObj"))
              .build();
        }
      }
    }
    return getSetNestedObjMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.GetInfo,
      io.grpc.examples.evotests.datatypes.MapObj> getGetMapObjMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getMapObj",
      requestType = io.grpc.examples.evotests.datatypes.GetInfo.class,
      responseType = io.grpc.examples.evotests.datatypes.MapObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.GetInfo,
      io.grpc.examples.evotests.datatypes.MapObj> getGetMapObjMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.GetInfo, io.grpc.examples.evotests.datatypes.MapObj> getGetMapObjMethod;
    if ((getGetMapObjMethod = DataTypesTestGrpc.getGetMapObjMethod) == null) {
      synchronized (DataTypesTestGrpc.class) {
        if ((getGetMapObjMethod = DataTypesTestGrpc.getGetMapObjMethod) == null) {
          DataTypesTestGrpc.getGetMapObjMethod = getGetMapObjMethod =
              io.grpc.MethodDescriptor.<io.grpc.examples.evotests.datatypes.GetInfo, io.grpc.examples.evotests.datatypes.MapObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getMapObj"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.evotests.datatypes.GetInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.evotests.datatypes.MapObj.getDefaultInstance()))
              .setSchemaDescriptor(new DataTypesTestMethodDescriptorSupplier("getMapObj"))
              .build();
        }
      }
    }
    return getGetMapObjMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.SimpleObj,
      io.grpc.examples.evotests.datatypes.MapObj> getAddMapObjMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addMapObj",
      requestType = io.grpc.examples.evotests.datatypes.SimpleObj.class,
      responseType = io.grpc.examples.evotests.datatypes.MapObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.SimpleObj,
      io.grpc.examples.evotests.datatypes.MapObj> getAddMapObjMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.SimpleObj, io.grpc.examples.evotests.datatypes.MapObj> getAddMapObjMethod;
    if ((getAddMapObjMethod = DataTypesTestGrpc.getAddMapObjMethod) == null) {
      synchronized (DataTypesTestGrpc.class) {
        if ((getAddMapObjMethod = DataTypesTestGrpc.getAddMapObjMethod) == null) {
          DataTypesTestGrpc.getAddMapObjMethod = getAddMapObjMethod =
              io.grpc.MethodDescriptor.<io.grpc.examples.evotests.datatypes.SimpleObj, io.grpc.examples.evotests.datatypes.MapObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addMapObj"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.evotests.datatypes.SimpleObj.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.evotests.datatypes.MapObj.getDefaultInstance()))
              .setSchemaDescriptor(new DataTypesTestMethodDescriptorSupplier("addMapObj"))
              .build();
        }
      }
    }
    return getAddMapObjMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.GetInfo,
      io.grpc.examples.evotests.datatypes.ListObj> getGetListObjMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getListObj",
      requestType = io.grpc.examples.evotests.datatypes.GetInfo.class,
      responseType = io.grpc.examples.evotests.datatypes.ListObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.GetInfo,
      io.grpc.examples.evotests.datatypes.ListObj> getGetListObjMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.GetInfo, io.grpc.examples.evotests.datatypes.ListObj> getGetListObjMethod;
    if ((getGetListObjMethod = DataTypesTestGrpc.getGetListObjMethod) == null) {
      synchronized (DataTypesTestGrpc.class) {
        if ((getGetListObjMethod = DataTypesTestGrpc.getGetListObjMethod) == null) {
          DataTypesTestGrpc.getGetListObjMethod = getGetListObjMethod =
              io.grpc.MethodDescriptor.<io.grpc.examples.evotests.datatypes.GetInfo, io.grpc.examples.evotests.datatypes.ListObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getListObj"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.evotests.datatypes.GetInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.evotests.datatypes.ListObj.getDefaultInstance()))
              .setSchemaDescriptor(new DataTypesTestMethodDescriptorSupplier("getListObj"))
              .build();
        }
      }
    }
    return getGetListObjMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.SimpleObj,
      io.grpc.examples.evotests.datatypes.ListObj> getAddListObjMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addListObj",
      requestType = io.grpc.examples.evotests.datatypes.SimpleObj.class,
      responseType = io.grpc.examples.evotests.datatypes.ListObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.SimpleObj,
      io.grpc.examples.evotests.datatypes.ListObj> getAddListObjMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.evotests.datatypes.SimpleObj, io.grpc.examples.evotests.datatypes.ListObj> getAddListObjMethod;
    if ((getAddListObjMethod = DataTypesTestGrpc.getAddListObjMethod) == null) {
      synchronized (DataTypesTestGrpc.class) {
        if ((getAddListObjMethod = DataTypesTestGrpc.getAddListObjMethod) == null) {
          DataTypesTestGrpc.getAddListObjMethod = getAddListObjMethod =
              io.grpc.MethodDescriptor.<io.grpc.examples.evotests.datatypes.SimpleObj, io.grpc.examples.evotests.datatypes.ListObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addListObj"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.evotests.datatypes.SimpleObj.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.evotests.datatypes.ListObj.getDefaultInstance()))
              .setSchemaDescriptor(new DataTypesTestMethodDescriptorSupplier("addListObj"))
              .build();
        }
      }
    }
    return getAddListObjMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataTypesTestStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTypesTestStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataTypesTestStub>() {
        @java.lang.Override
        public DataTypesTestStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataTypesTestStub(channel, callOptions);
        }
      };
    return DataTypesTestStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataTypesTestBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTypesTestBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataTypesTestBlockingStub>() {
        @java.lang.Override
        public DataTypesTestBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataTypesTestBlockingStub(channel, callOptions);
        }
      };
    return DataTypesTestBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataTypesTestFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTypesTestFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataTypesTestFutureStub>() {
        @java.lang.Override
        public DataTypesTestFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataTypesTestFutureStub(channel, callOptions);
        }
      };
    return DataTypesTestFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getSimpleObj(io.grpc.examples.evotests.datatypes.GetInfo request,
        io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.SimpleObj> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSimpleObjMethod(), responseObserver);
    }

    /**
     */
    default void getNestedObj(io.grpc.examples.evotests.datatypes.GetInfo request,
        io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.NestedObj> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNestedObjMethod(), responseObserver);
    }

    /**
     */
    default void setNestedObj(io.grpc.examples.evotests.datatypes.SimpleObj request,
        io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.NestedObj> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetNestedObjMethod(), responseObserver);
    }

    /**
     */
    default void getMapObj(io.grpc.examples.evotests.datatypes.GetInfo request,
        io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.MapObj> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMapObjMethod(), responseObserver);
    }

    /**
     */
    default void addMapObj(io.grpc.examples.evotests.datatypes.SimpleObj request,
        io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.MapObj> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddMapObjMethod(), responseObserver);
    }

    /**
     */
    default void getListObj(io.grpc.examples.evotests.datatypes.GetInfo request,
        io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.ListObj> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetListObjMethod(), responseObserver);
    }

    /**
     */
    default void addListObj(io.grpc.examples.evotests.datatypes.SimpleObj request,
        io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.ListObj> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddListObjMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataTypesTest.
   */
  public static abstract class DataTypesTestImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return DataTypesTestGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataTypesTest.
   */
  public static final class DataTypesTestStub
      extends io.grpc.stub.AbstractAsyncStub<DataTypesTestStub> {
    private DataTypesTestStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTypesTestStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTypesTestStub(channel, callOptions);
    }

    /**
     */
    public void getSimpleObj(io.grpc.examples.evotests.datatypes.GetInfo request,
        io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.SimpleObj> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSimpleObjMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getNestedObj(io.grpc.examples.evotests.datatypes.GetInfo request,
        io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.NestedObj> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNestedObjMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setNestedObj(io.grpc.examples.evotests.datatypes.SimpleObj request,
        io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.NestedObj> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetNestedObjMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMapObj(io.grpc.examples.evotests.datatypes.GetInfo request,
        io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.MapObj> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMapObjMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addMapObj(io.grpc.examples.evotests.datatypes.SimpleObj request,
        io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.MapObj> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddMapObjMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getListObj(io.grpc.examples.evotests.datatypes.GetInfo request,
        io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.ListObj> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetListObjMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addListObj(io.grpc.examples.evotests.datatypes.SimpleObj request,
        io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.ListObj> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddListObjMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataTypesTest.
   */
  public static final class DataTypesTestBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataTypesTestBlockingStub> {
    private DataTypesTestBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTypesTestBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTypesTestBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.examples.evotests.datatypes.SimpleObj getSimpleObj(io.grpc.examples.evotests.datatypes.GetInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSimpleObjMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.examples.evotests.datatypes.NestedObj getNestedObj(io.grpc.examples.evotests.datatypes.GetInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNestedObjMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.examples.evotests.datatypes.NestedObj setNestedObj(io.grpc.examples.evotests.datatypes.SimpleObj request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetNestedObjMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.examples.evotests.datatypes.MapObj getMapObj(io.grpc.examples.evotests.datatypes.GetInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMapObjMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.examples.evotests.datatypes.MapObj addMapObj(io.grpc.examples.evotests.datatypes.SimpleObj request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddMapObjMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.examples.evotests.datatypes.ListObj getListObj(io.grpc.examples.evotests.datatypes.GetInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetListObjMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.examples.evotests.datatypes.ListObj addListObj(io.grpc.examples.evotests.datatypes.SimpleObj request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddListObjMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataTypesTest.
   */
  public static final class DataTypesTestFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataTypesTestFutureStub> {
    private DataTypesTestFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTypesTestFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTypesTestFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.evotests.datatypes.SimpleObj> getSimpleObj(
        io.grpc.examples.evotests.datatypes.GetInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSimpleObjMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.evotests.datatypes.NestedObj> getNestedObj(
        io.grpc.examples.evotests.datatypes.GetInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNestedObjMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.evotests.datatypes.NestedObj> setNestedObj(
        io.grpc.examples.evotests.datatypes.SimpleObj request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetNestedObjMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.evotests.datatypes.MapObj> getMapObj(
        io.grpc.examples.evotests.datatypes.GetInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMapObjMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.evotests.datatypes.MapObj> addMapObj(
        io.grpc.examples.evotests.datatypes.SimpleObj request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddMapObjMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.evotests.datatypes.ListObj> getListObj(
        io.grpc.examples.evotests.datatypes.GetInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetListObjMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.evotests.datatypes.ListObj> addListObj(
        io.grpc.examples.evotests.datatypes.SimpleObj request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddListObjMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SIMPLE_OBJ = 0;
  private static final int METHODID_GET_NESTED_OBJ = 1;
  private static final int METHODID_SET_NESTED_OBJ = 2;
  private static final int METHODID_GET_MAP_OBJ = 3;
  private static final int METHODID_ADD_MAP_OBJ = 4;
  private static final int METHODID_GET_LIST_OBJ = 5;
  private static final int METHODID_ADD_LIST_OBJ = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SIMPLE_OBJ:
          serviceImpl.getSimpleObj((io.grpc.examples.evotests.datatypes.GetInfo) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.SimpleObj>) responseObserver);
          break;
        case METHODID_GET_NESTED_OBJ:
          serviceImpl.getNestedObj((io.grpc.examples.evotests.datatypes.GetInfo) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.NestedObj>) responseObserver);
          break;
        case METHODID_SET_NESTED_OBJ:
          serviceImpl.setNestedObj((io.grpc.examples.evotests.datatypes.SimpleObj) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.NestedObj>) responseObserver);
          break;
        case METHODID_GET_MAP_OBJ:
          serviceImpl.getMapObj((io.grpc.examples.evotests.datatypes.GetInfo) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.MapObj>) responseObserver);
          break;
        case METHODID_ADD_MAP_OBJ:
          serviceImpl.addMapObj((io.grpc.examples.evotests.datatypes.SimpleObj) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.MapObj>) responseObserver);
          break;
        case METHODID_GET_LIST_OBJ:
          serviceImpl.getListObj((io.grpc.examples.evotests.datatypes.GetInfo) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.ListObj>) responseObserver);
          break;
        case METHODID_ADD_LIST_OBJ:
          serviceImpl.addListObj((io.grpc.examples.evotests.datatypes.SimpleObj) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.evotests.datatypes.ListObj>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetSimpleObjMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.grpc.examples.evotests.datatypes.GetInfo,
              io.grpc.examples.evotests.datatypes.SimpleObj>(
                service, METHODID_GET_SIMPLE_OBJ)))
        .addMethod(
          getGetNestedObjMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.grpc.examples.evotests.datatypes.GetInfo,
              io.grpc.examples.evotests.datatypes.NestedObj>(
                service, METHODID_GET_NESTED_OBJ)))
        .addMethod(
          getSetNestedObjMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.grpc.examples.evotests.datatypes.SimpleObj,
              io.grpc.examples.evotests.datatypes.NestedObj>(
                service, METHODID_SET_NESTED_OBJ)))
        .addMethod(
          getGetMapObjMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.grpc.examples.evotests.datatypes.GetInfo,
              io.grpc.examples.evotests.datatypes.MapObj>(
                service, METHODID_GET_MAP_OBJ)))
        .addMethod(
          getAddMapObjMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.grpc.examples.evotests.datatypes.SimpleObj,
              io.grpc.examples.evotests.datatypes.MapObj>(
                service, METHODID_ADD_MAP_OBJ)))
        .addMethod(
          getGetListObjMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.grpc.examples.evotests.datatypes.GetInfo,
              io.grpc.examples.evotests.datatypes.ListObj>(
                service, METHODID_GET_LIST_OBJ)))
        .addMethod(
          getAddListObjMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.grpc.examples.evotests.datatypes.SimpleObj,
              io.grpc.examples.evotests.datatypes.ListObj>(
                service, METHODID_ADD_LIST_OBJ)))
        .build();
  }

  private static abstract class DataTypesTestBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataTypesTestBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.examples.evotests.datatypes.DataTypesTestProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataTypesTest");
    }
  }

  private static final class DataTypesTestFileDescriptorSupplier
      extends DataTypesTestBaseDescriptorSupplier {
    DataTypesTestFileDescriptorSupplier() {}
  }

  private static final class DataTypesTestMethodDescriptorSupplier
      extends DataTypesTestBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataTypesTestMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DataTypesTestGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataTypesTestFileDescriptorSupplier())
              .addMethod(getGetSimpleObjMethod())
              .addMethod(getGetNestedObjMethod())
              .addMethod(getSetNestedObjMethod())
              .addMethod(getGetMapObjMethod())
              .addMethod(getAddMapObjMethod())
              .addMethod(getGetListObjMethod())
              .addMethod(getAddListObjMethod())
              .build();
        }
      }
    }
    return result;
  }
}
