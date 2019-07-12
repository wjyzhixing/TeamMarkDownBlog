// ORM class for table 'analysis_global'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Thu Jul 11 11:13:31 CST 2019
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class analysis_global extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("shenghui", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        analysis_global.this.shenghui = (String)value;
      }
    });
    setters.put("jingdu", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        analysis_global.this.jingdu = (Float)value;
      }
    });
    setters.put("weidu", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        analysis_global.this.weidu = (Float)value;
      }
    });
    setters.put("renshu", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        analysis_global.this.renshu = (Integer)value;
      }
    });
  }
  public analysis_global() {
    init0();
  }
  private String shenghui;
  public String get_shenghui() {
    return shenghui;
  }
  public void set_shenghui(String shenghui) {
    this.shenghui = shenghui;
  }
  public analysis_global with_shenghui(String shenghui) {
    this.shenghui = shenghui;
    return this;
  }
  private Float jingdu;
  public Float get_jingdu() {
    return jingdu;
  }
  public void set_jingdu(Float jingdu) {
    this.jingdu = jingdu;
  }
  public analysis_global with_jingdu(Float jingdu) {
    this.jingdu = jingdu;
    return this;
  }
  private Float weidu;
  public Float get_weidu() {
    return weidu;
  }
  public void set_weidu(Float weidu) {
    this.weidu = weidu;
  }
  public analysis_global with_weidu(Float weidu) {
    this.weidu = weidu;
    return this;
  }
  private Integer renshu;
  public Integer get_renshu() {
    return renshu;
  }
  public void set_renshu(Integer renshu) {
    this.renshu = renshu;
  }
  public analysis_global with_renshu(Integer renshu) {
    this.renshu = renshu;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof analysis_global)) {
      return false;
    }
    analysis_global that = (analysis_global) o;
    boolean equal = true;
    equal = equal && (this.shenghui == null ? that.shenghui == null : this.shenghui.equals(that.shenghui));
    equal = equal && (this.jingdu == null ? that.jingdu == null : this.jingdu.equals(that.jingdu));
    equal = equal && (this.weidu == null ? that.weidu == null : this.weidu.equals(that.weidu));
    equal = equal && (this.renshu == null ? that.renshu == null : this.renshu.equals(that.renshu));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof analysis_global)) {
      return false;
    }
    analysis_global that = (analysis_global) o;
    boolean equal = true;
    equal = equal && (this.shenghui == null ? that.shenghui == null : this.shenghui.equals(that.shenghui));
    equal = equal && (this.jingdu == null ? that.jingdu == null : this.jingdu.equals(that.jingdu));
    equal = equal && (this.weidu == null ? that.weidu == null : this.weidu.equals(that.weidu));
    equal = equal && (this.renshu == null ? that.renshu == null : this.renshu.equals(that.renshu));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.shenghui = JdbcWritableBridge.readString(1, __dbResults);
    this.jingdu = JdbcWritableBridge.readFloat(2, __dbResults);
    this.weidu = JdbcWritableBridge.readFloat(3, __dbResults);
    this.renshu = JdbcWritableBridge.readInteger(4, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.shenghui = JdbcWritableBridge.readString(1, __dbResults);
    this.jingdu = JdbcWritableBridge.readFloat(2, __dbResults);
    this.weidu = JdbcWritableBridge.readFloat(3, __dbResults);
    this.renshu = JdbcWritableBridge.readInteger(4, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(shenghui, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeFloat(jingdu, 2 + __off, 7, __dbStmt);
    JdbcWritableBridge.writeFloat(weidu, 3 + __off, 7, __dbStmt);
    JdbcWritableBridge.writeInteger(renshu, 4 + __off, 4, __dbStmt);
    return 4;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(shenghui, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeFloat(jingdu, 2 + __off, 7, __dbStmt);
    JdbcWritableBridge.writeFloat(weidu, 3 + __off, 7, __dbStmt);
    JdbcWritableBridge.writeInteger(renshu, 4 + __off, 4, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.shenghui = null;
    } else {
    this.shenghui = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.jingdu = null;
    } else {
    this.jingdu = Float.valueOf(__dataIn.readFloat());
    }
    if (__dataIn.readBoolean()) { 
        this.weidu = null;
    } else {
    this.weidu = Float.valueOf(__dataIn.readFloat());
    }
    if (__dataIn.readBoolean()) { 
        this.renshu = null;
    } else {
    this.renshu = Integer.valueOf(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.shenghui) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, shenghui);
    }
    if (null == this.jingdu) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeFloat(this.jingdu);
    }
    if (null == this.weidu) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeFloat(this.weidu);
    }
    if (null == this.renshu) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.renshu);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.shenghui) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, shenghui);
    }
    if (null == this.jingdu) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeFloat(this.jingdu);
    }
    if (null == this.weidu) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeFloat(this.weidu);
    }
    if (null == this.renshu) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.renshu);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 9, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(shenghui==null?"null":shenghui, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(jingdu==null?"null":"" + jingdu, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(weidu==null?"null":"" + weidu, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(renshu==null?"null":"" + renshu, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(shenghui==null?"null":shenghui, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(jingdu==null?"null":"" + jingdu, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(weidu==null?"null":"" + weidu, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(renshu==null?"null":"" + renshu, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 9, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.shenghui = null; } else {
      this.shenghui = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.jingdu = null; } else {
      this.jingdu = Float.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.weidu = null; } else {
      this.weidu = Float.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.renshu = null; } else {
      this.renshu = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.shenghui = null; } else {
      this.shenghui = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.jingdu = null; } else {
      this.jingdu = Float.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.weidu = null; } else {
      this.weidu = Float.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.renshu = null; } else {
      this.renshu = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    analysis_global o = (analysis_global) super.clone();
    return o;
  }

  public void clone0(analysis_global o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("shenghui", this.shenghui);
    __sqoop$field_map.put("jingdu", this.jingdu);
    __sqoop$field_map.put("weidu", this.weidu);
    __sqoop$field_map.put("renshu", this.renshu);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("shenghui", this.shenghui);
    __sqoop$field_map.put("jingdu", this.jingdu);
    __sqoop$field_map.put("weidu", this.weidu);
    __sqoop$field_map.put("renshu", this.renshu);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
