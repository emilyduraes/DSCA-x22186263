// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PatientRegistrationService.proto

package ie.nci.PatientRegistrationService;

/**
 * Protobuf type {@code PatientRegistrationService.PatientRequest}
 */
public  final class PatientRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:PatientRegistrationService.PatientRequest)
    PatientRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PatientRequest.newBuilder() to construct.
  private PatientRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PatientRequest() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PatientRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            ie.nci.PatientRegistrationService.Patient.Builder subBuilder = null;
            if (patient_ != null) {
              subBuilder = patient_.toBuilder();
            }
            patient_ = input.readMessage(ie.nci.PatientRegistrationService.Patient.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(patient_);
              patient_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ie.nci.PatientRegistrationService.PatientRegistrationServiceImpl.internal_static_PatientRegistrationService_PatientRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ie.nci.PatientRegistrationService.PatientRegistrationServiceImpl.internal_static_PatientRegistrationService_PatientRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ie.nci.PatientRegistrationService.PatientRequest.class, ie.nci.PatientRegistrationService.PatientRequest.Builder.class);
  }

  public static final int PATIENT_FIELD_NUMBER = 1;
  private ie.nci.PatientRegistrationService.Patient patient_;
  /**
   * <code>.PatientRegistrationService.Patient patient = 1;</code>
   */
  public boolean hasPatient() {
    return patient_ != null;
  }
  /**
   * <code>.PatientRegistrationService.Patient patient = 1;</code>
   */
  public ie.nci.PatientRegistrationService.Patient getPatient() {
    return patient_ == null ? ie.nci.PatientRegistrationService.Patient.getDefaultInstance() : patient_;
  }
  /**
   * <code>.PatientRegistrationService.Patient patient = 1;</code>
   */
  public ie.nci.PatientRegistrationService.PatientOrBuilder getPatientOrBuilder() {
    return getPatient();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (patient_ != null) {
      output.writeMessage(1, getPatient());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (patient_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getPatient());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ie.nci.PatientRegistrationService.PatientRequest)) {
      return super.equals(obj);
    }
    ie.nci.PatientRegistrationService.PatientRequest other = (ie.nci.PatientRegistrationService.PatientRequest) obj;

    boolean result = true;
    result = result && (hasPatient() == other.hasPatient());
    if (hasPatient()) {
      result = result && getPatient()
          .equals(other.getPatient());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasPatient()) {
      hash = (37 * hash) + PATIENT_FIELD_NUMBER;
      hash = (53 * hash) + getPatient().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ie.nci.PatientRegistrationService.PatientRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.nci.PatientRegistrationService.PatientRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.nci.PatientRegistrationService.PatientRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.nci.PatientRegistrationService.PatientRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.nci.PatientRegistrationService.PatientRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.nci.PatientRegistrationService.PatientRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.nci.PatientRegistrationService.PatientRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ie.nci.PatientRegistrationService.PatientRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ie.nci.PatientRegistrationService.PatientRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ie.nci.PatientRegistrationService.PatientRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ie.nci.PatientRegistrationService.PatientRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ie.nci.PatientRegistrationService.PatientRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ie.nci.PatientRegistrationService.PatientRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code PatientRegistrationService.PatientRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:PatientRegistrationService.PatientRequest)
      ie.nci.PatientRegistrationService.PatientRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ie.nci.PatientRegistrationService.PatientRegistrationServiceImpl.internal_static_PatientRegistrationService_PatientRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ie.nci.PatientRegistrationService.PatientRegistrationServiceImpl.internal_static_PatientRegistrationService_PatientRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ie.nci.PatientRegistrationService.PatientRequest.class, ie.nci.PatientRegistrationService.PatientRequest.Builder.class);
    }

    // Construct using ie.nci.PatientRegistrationService.PatientRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (patientBuilder_ == null) {
        patient_ = null;
      } else {
        patient_ = null;
        patientBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ie.nci.PatientRegistrationService.PatientRegistrationServiceImpl.internal_static_PatientRegistrationService_PatientRequest_descriptor;
    }

    @java.lang.Override
    public ie.nci.PatientRegistrationService.PatientRequest getDefaultInstanceForType() {
      return ie.nci.PatientRegistrationService.PatientRequest.getDefaultInstance();
    }

    @java.lang.Override
    public ie.nci.PatientRegistrationService.PatientRequest build() {
      ie.nci.PatientRegistrationService.PatientRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ie.nci.PatientRegistrationService.PatientRequest buildPartial() {
      ie.nci.PatientRegistrationService.PatientRequest result = new ie.nci.PatientRegistrationService.PatientRequest(this);
      if (patientBuilder_ == null) {
        result.patient_ = patient_;
      } else {
        result.patient_ = patientBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ie.nci.PatientRegistrationService.PatientRequest) {
        return mergeFrom((ie.nci.PatientRegistrationService.PatientRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ie.nci.PatientRegistrationService.PatientRequest other) {
      if (other == ie.nci.PatientRegistrationService.PatientRequest.getDefaultInstance()) return this;
      if (other.hasPatient()) {
        mergePatient(other.getPatient());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ie.nci.PatientRegistrationService.PatientRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ie.nci.PatientRegistrationService.PatientRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private ie.nci.PatientRegistrationService.Patient patient_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        ie.nci.PatientRegistrationService.Patient, ie.nci.PatientRegistrationService.Patient.Builder, ie.nci.PatientRegistrationService.PatientOrBuilder> patientBuilder_;
    /**
     * <code>.PatientRegistrationService.Patient patient = 1;</code>
     */
    public boolean hasPatient() {
      return patientBuilder_ != null || patient_ != null;
    }
    /**
     * <code>.PatientRegistrationService.Patient patient = 1;</code>
     */
    public ie.nci.PatientRegistrationService.Patient getPatient() {
      if (patientBuilder_ == null) {
        return patient_ == null ? ie.nci.PatientRegistrationService.Patient.getDefaultInstance() : patient_;
      } else {
        return patientBuilder_.getMessage();
      }
    }
    /**
     * <code>.PatientRegistrationService.Patient patient = 1;</code>
     */
    public Builder setPatient(ie.nci.PatientRegistrationService.Patient value) {
      if (patientBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        patient_ = value;
        onChanged();
      } else {
        patientBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.PatientRegistrationService.Patient patient = 1;</code>
     */
    public Builder setPatient(
        ie.nci.PatientRegistrationService.Patient.Builder builderForValue) {
      if (patientBuilder_ == null) {
        patient_ = builderForValue.build();
        onChanged();
      } else {
        patientBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.PatientRegistrationService.Patient patient = 1;</code>
     */
    public Builder mergePatient(ie.nci.PatientRegistrationService.Patient value) {
      if (patientBuilder_ == null) {
        if (patient_ != null) {
          patient_ =
            ie.nci.PatientRegistrationService.Patient.newBuilder(patient_).mergeFrom(value).buildPartial();
        } else {
          patient_ = value;
        }
        onChanged();
      } else {
        patientBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.PatientRegistrationService.Patient patient = 1;</code>
     */
    public Builder clearPatient() {
      if (patientBuilder_ == null) {
        patient_ = null;
        onChanged();
      } else {
        patient_ = null;
        patientBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.PatientRegistrationService.Patient patient = 1;</code>
     */
    public ie.nci.PatientRegistrationService.Patient.Builder getPatientBuilder() {
      
      onChanged();
      return getPatientFieldBuilder().getBuilder();
    }
    /**
     * <code>.PatientRegistrationService.Patient patient = 1;</code>
     */
    public ie.nci.PatientRegistrationService.PatientOrBuilder getPatientOrBuilder() {
      if (patientBuilder_ != null) {
        return patientBuilder_.getMessageOrBuilder();
      } else {
        return patient_ == null ?
            ie.nci.PatientRegistrationService.Patient.getDefaultInstance() : patient_;
      }
    }
    /**
     * <code>.PatientRegistrationService.Patient patient = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        ie.nci.PatientRegistrationService.Patient, ie.nci.PatientRegistrationService.Patient.Builder, ie.nci.PatientRegistrationService.PatientOrBuilder> 
        getPatientFieldBuilder() {
      if (patientBuilder_ == null) {
        patientBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            ie.nci.PatientRegistrationService.Patient, ie.nci.PatientRegistrationService.Patient.Builder, ie.nci.PatientRegistrationService.PatientOrBuilder>(
                getPatient(),
                getParentForChildren(),
                isClean());
        patient_ = null;
      }
      return patientBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:PatientRegistrationService.PatientRequest)
  }

  // @@protoc_insertion_point(class_scope:PatientRegistrationService.PatientRequest)
  private static final ie.nci.PatientRegistrationService.PatientRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ie.nci.PatientRegistrationService.PatientRequest();
  }

  public static ie.nci.PatientRegistrationService.PatientRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PatientRequest>
      PARSER = new com.google.protobuf.AbstractParser<PatientRequest>() {
    @java.lang.Override
    public PatientRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PatientRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PatientRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PatientRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ie.nci.PatientRegistrationService.PatientRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
