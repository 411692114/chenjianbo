// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: IMessageBuf.proto

package com.sinsz.netty.proto;

public final class IMessage {
  private IMessage() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface IMessageBufOrBuilder extends
      // @@protoc_insertion_point(interface_extends:IMessageBuf)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string username = 1;</code>
     */
    String getUsername();
    /**
     * <code>optional string username = 1;</code>
     */
    com.google.protobuf.ByteString
        getUsernameBytes();

    /**
     * <code>optional string content = 2;</code>
     */
    String getContent();
    /**
     * <code>optional string content = 2;</code>
     */
    com.google.protobuf.ByteString
        getContentBytes();

    /**
     * <code>optional bool state = 3;</code>
     */
    boolean getState();
  }
  /**
   * Protobuf type {@code IMessageBuf}
   */
  public  static final class IMessageBuf extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:IMessageBuf)
      IMessageBufOrBuilder {
    // Use IMessageBuf.newBuilder() to construct.
    private IMessageBuf(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private IMessageBuf() {
      username_ = "";
      content_ = "";
      state_ = false;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private IMessageBuf(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              String s = input.readStringRequireUtf8();

              username_ = s;
              break;
            }
            case 18: {
              String s = input.readStringRequireUtf8();

              content_ = s;
              break;
            }
            case 24: {

              state_ = input.readBool();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return IMessage.internal_static_IMessageBuf_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return IMessage.internal_static_IMessageBuf_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              IMessageBuf.class, Builder.class);
    }

    public static final int USERNAME_FIELD_NUMBER = 1;
    private volatile Object username_;
    /**
     * <code>optional string username = 1;</code>
     */
    public String getUsername() {
      Object ref = username_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        username_ = s;
        return s;
      }
    }
    /**
     * <code>optional string username = 1;</code>
     */
    public com.google.protobuf.ByteString
        getUsernameBytes() {
      Object ref = username_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        username_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CONTENT_FIELD_NUMBER = 2;
    private volatile Object content_;
    /**
     * <code>optional string content = 2;</code>
     */
    public String getContent() {
      Object ref = content_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        content_ = s;
        return s;
      }
    }
    /**
     * <code>optional string content = 2;</code>
     */
    public com.google.protobuf.ByteString
        getContentBytes() {
      Object ref = content_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        content_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int STATE_FIELD_NUMBER = 3;
    private boolean state_;
    /**
     * <code>optional bool state = 3;</code>
     */
    public boolean getState() {
      return state_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getUsernameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, username_);
      }
      if (!getContentBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, content_);
      }
      if (state_ != false) {
        output.writeBool(3, state_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getUsernameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, username_);
      }
      if (!getContentBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, content_);
      }
      if (state_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(3, state_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof IMessageBuf)) {
        return super.equals(obj);
      }
      IMessageBuf other = (IMessageBuf) obj;

      boolean result = true;
      result = result && getUsername()
          .equals(other.getUsername());
      result = result && getContent()
          .equals(other.getContent());
      result = result && (getState()
          == other.getState());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + USERNAME_FIELD_NUMBER;
      hash = (53 * hash) + getUsername().hashCode();
      hash = (37 * hash) + CONTENT_FIELD_NUMBER;
      hash = (53 * hash) + getContent().hashCode();
      hash = (37 * hash) + STATE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getState());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static IMessageBuf parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static IMessageBuf parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static IMessageBuf parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static IMessageBuf parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static IMessageBuf parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static IMessageBuf parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static IMessageBuf parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static IMessageBuf parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static IMessageBuf parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static IMessageBuf parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(IMessageBuf prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code IMessageBuf}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:IMessageBuf)
        IMessageBufOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return IMessage.internal_static_IMessageBuf_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return IMessage.internal_static_IMessageBuf_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                IMessageBuf.class, Builder.class);
      }

      // Construct using com.sinsz.netty.proto.IMessage.IMessageBuf.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        username_ = "";

        content_ = "";

        state_ = false;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return IMessage.internal_static_IMessageBuf_descriptor;
      }

      public IMessageBuf getDefaultInstanceForType() {
        return IMessageBuf.getDefaultInstance();
      }

      public IMessageBuf build() {
        IMessageBuf result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public IMessageBuf buildPartial() {
        IMessageBuf result = new IMessageBuf(this);
        result.username_ = username_;
        result.content_ = content_;
        result.state_ = state_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof IMessageBuf) {
          return mergeFrom((IMessageBuf)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(IMessageBuf other) {
        if (other == IMessageBuf.getDefaultInstance()) return this;
        if (!other.getUsername().isEmpty()) {
          username_ = other.username_;
          onChanged();
        }
        if (!other.getContent().isEmpty()) {
          content_ = other.content_;
          onChanged();
        }
        if (other.getState() != false) {
          setState(other.getState());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        IMessageBuf parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (IMessageBuf) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private Object username_ = "";
      /**
       * <code>optional string username = 1;</code>
       */
      public String getUsername() {
        Object ref = username_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          username_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string username = 1;</code>
       */
      public com.google.protobuf.ByteString
          getUsernameBytes() {
        Object ref = username_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          username_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string username = 1;</code>
       */
      public Builder setUsername(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }

        username_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string username = 1;</code>
       */
      public Builder clearUsername() {

        username_ = getDefaultInstance().getUsername();
        onChanged();
        return this;
      }
      /**
       * <code>optional string username = 1;</code>
       */
      public Builder setUsernameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

        username_ = value;
        onChanged();
        return this;
      }

      private Object content_ = "";
      /**
       * <code>optional string content = 2;</code>
       */
      public String getContent() {
        Object ref = content_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          content_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string content = 2;</code>
       */
      public com.google.protobuf.ByteString
          getContentBytes() {
        Object ref = content_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          content_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string content = 2;</code>
       */
      public Builder setContent(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }

        content_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string content = 2;</code>
       */
      public Builder clearContent() {

        content_ = getDefaultInstance().getContent();
        onChanged();
        return this;
      }
      /**
       * <code>optional string content = 2;</code>
       */
      public Builder setContentBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

        content_ = value;
        onChanged();
        return this;
      }

      private boolean state_ ;
      /**
       * <code>optional bool state = 3;</code>
       */
      public boolean getState() {
        return state_;
      }
      /**
       * <code>optional bool state = 3;</code>
       */
      public Builder setState(boolean value) {

        state_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool state = 3;</code>
       */
      public Builder clearState() {

        state_ = false;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:IMessageBuf)
    }

    // @@protoc_insertion_point(class_scope:IMessageBuf)
    private static final IMessageBuf DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new IMessageBuf();
    }

    public static IMessageBuf getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<IMessageBuf>
        PARSER = new com.google.protobuf.AbstractParser<IMessageBuf>() {
      public IMessageBuf parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new IMessageBuf(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<IMessageBuf> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<IMessageBuf> getParserForType() {
      return PARSER;
    }

    public IMessageBuf getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_IMessageBuf_descriptor;
  private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_IMessageBuf_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\021IMessageBuf.proto\"?\n\013IMessageBuf\022\020\n\010us" +
      "ername\030\001 \001(\t\022\017\n\007content\030\002 \001(\t\022\r\n\005state\030\003" +
      " \001(\010B!\n\025com.sinsz.netty.protoB\010IMessageb" +
      "\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_IMessageBuf_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_IMessageBuf_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_IMessageBuf_descriptor,
        new String[] { "Username", "Content", "State", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
