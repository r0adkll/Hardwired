package com.r0adkll.hardwired.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import ollie.Model;
import ollie.annotation.Column;
import ollie.annotation.Table;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/12/16.
 */
@Table("computers")
public class Computer extends Model implements Parcelable{

    @Column("ip_address")
    public String ipAddress;

    @Column("port")
    public Integer port;

    @Column("name")
    public String name;

    public Computer(){}

    protected Computer(Parcel in) {
        ipAddress = in.readString();
        port = in.readInt();
        name = in.readString();
    }

    public String getBaseUri(){
        return String.format("http://%s:%04d", ipAddress, port);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ipAddress);
        dest.writeInt(port);
        dest.writeString(name);
    }

    public static final Creator<Computer> CREATOR = new Creator<Computer>() {
        @Override
        public Computer createFromParcel(Parcel in) {
            return new Computer(in);
        }

        @Override
        public Computer[] newArray(int size) {
            return new Computer[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Computer computer = (Computer) o;

        if (ipAddress != null ? !ipAddress.equals(computer.ipAddress) : computer.ipAddress != null)
            return false;
        if (port != null ? !port.equals(computer.port) : computer.port != null) return false;
        return name != null ? name.equals(computer.name) : computer.name == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
        result = 31 * result + (port != null ? port.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public static class Builder{

        private Computer computer;

        public Builder(){
            computer = new Computer();
        }

        public Builder name(String name){
            computer.name = name;
            return this;
        }

        public Builder ip(String address){
            computer.ipAddress = address;
            return this;
        }

        public Builder port(int port){
            computer.port = port;
            return this;
        }

        public Computer build(){
            return computer;
        }

    }

}
