
package ru.parhomych.weatherparhomych.city;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.builder.ToStringBuilder;

public class City implements Serializable {

    @SerializedName("Version")
    private Integer version;
    @SerializedName("Key")
    private String key;
    @SerializedName("Type")
    private String type;
    @SerializedName("Rank")
    private Integer rank;
    @SerializedName("LocalizedName")
    private String localizedName;
    @SerializedName("Country")
    private Country country;
    @SerializedName("AdministrativeArea")
    private AdministrativeArea administrativeArea;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public City() {
    }

    /**
     * 
     * @param country
     * @param localizedName
     * @param rank
     * @param type
     * @param administrativeArea
     * @param version
     * @param key
     */
    public City(Integer version, String key, String type, Integer rank, String localizedName, Country country, AdministrativeArea administrativeArea) {
        super();
        this.version = version;
        this.key = key;
        this.type = type;
        this.rank = rank;
        this.localizedName = localizedName;
        this.country = country;
        this.administrativeArea = administrativeArea;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public AdministrativeArea getAdministrativeArea() {
        return administrativeArea;
    }

    public void setAdministrativeArea(AdministrativeArea administrativeArea) {
        this.administrativeArea = administrativeArea;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("version", version)
                .append("key", key)
                .append("type", type)
                .append("rank", rank)
                .append("localizedName", localizedName)
                .append("country", country)
                .append("administrativeArea", administrativeArea)
                .append("additionalProperties", additionalProperties).toString();
    }

}
