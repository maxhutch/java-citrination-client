package io.citrine.jcc.search.pif.result;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.citrine.jpif.obj.system.System;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Class to store a single PIF search hit.
 *
 * @author Kyle Michel
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PifSearchHit {

    /**
     * Set the id of the record that was matched.
     *
     * @param id String with the id of the record.
     * @return This object.
     */
    @JsonSetter("id")
    public PifSearchHit setId(final String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the id of the record that was matched.
     *
     * @return String with the id of the matched record or a null pointer if not set.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Set the dataset of the record that was matched.
     *
     * @param dataset Long with the dataset of the record.
     * @return This object.
     */
    @JsonSetter("dataset")
    public PifSearchHit setDataset(final Long dataset) {
        this.dataset = dataset;
        return this;
    }

    /**
     * Get the dataset of the record that was matched.
     *
     * @return String with the dataset of the matched record or a null pointer if not set.
     */
    @JsonGetter("dataset")
    public Long getDataset() {
        return this.dataset;
    }

    /**
     * Set the dataset version of the record that was matched.
     *
     * @param datasetVersion Long with the dataset version of the record.
     * @return This object.
     */
    @JsonSetter("datasetVersion")
    public PifSearchHit setDatasetVersion(final Long datasetVersion) {
        this.datasetVersion = datasetVersion;
        return this;
    }

    /**
     * Get the dataset version of the record that was matched.
     *
     * @return String with the dataset version of the matched record or a null pointer if not set.
     */
    @JsonGetter("datasetVersion")
    public Long getDatasetVersion() {
        return this.datasetVersion;
    }

    /**
     * Set the score for a hit.
     *
     * @param score Double with the score for the hit.
     * @return This object.
     */
    @JsonSetter("score")
    public PifSearchHit setScore(final Double score) {
        this.score = score;
        return this;
    }

    /**
     * Get the score for a hit.
     *
     * @return Double with the score for the hit or a null pointer if not set.
     */
    @JsonGetter("score")
    public Double getScore() {
        return this.score;
    }

    /**
     * Set the system that was matched.
     *
     * @param system {@link System} to save in the result
     * @return This object.
     */
    @JsonSetter("system")
    public PifSearchHit setSystem(final System system) {
        this.system = system;
        return this;
    }

    /**
     * Get the system that was matched.
     *
     * @return {@link System} with the record that was matched or a null pointer if it has not been set.
     */
    @JsonGetter("system")
    public System getSystem() {
        return this.system;
    }

    /**
     * Set the map of extracted values.
     *
     * @param extracted Map of extracted value names to values.
     * @return This object.
     */
    @JsonSetter("extracted")
    protected PifSearchHit setExtracted(final Map<String, String> extracted) {
        this.extracted = extracted;
        return this;
    }

    /**
     * Add to the map of extracted values.
     *
     * @param extracted Map of extracted value names to values.
     * @return This object.
     */
    @JsonIgnore
    public PifSearchHit addExtracted(final Map<String, String> extracted) {
        if (extracted != null) {
            if (this.extracted == null) {
                this.extracted = new HashMap<>();
            }
            this.extracted.putAll(extracted);
        }
        return this;
    }

    /**
     * Add to the map of extracted values.
     *
     * @param key Name of the extracted value.
     * @param value Value that was extracted.
     * @return This object.
     */
    @JsonIgnore
    public PifSearchHit addExtracted(final String key, final String value) {
        if (this.extracted == null) {
            this.extracted = new HashMap<>();
        }
        this.extracted.put(key, value);
        return this;
    }

    /**
     * Get the map of extracted values.
     *
     * @return Map of extracted field keys to values.
     */
    @JsonGetter("extracted")
    protected Map<String, String> getExtracted() {
        return this.extracted;
    }

    /**
     * Get the list of extracted value keys.
     *
     * @return Set with the extracted keys.
     */
    @JsonIgnore
    public Set<String> getExtractedKeys() {
        return (this.extracted == null) ? null : this.extracted.keySet();
    }

    /**
     * Get an extracted value by its key.
     *
     * @param key String with the key of the extracted value.
     * @return String with the value of the input key or a null pointer if that key is not available.
     */
    @JsonIgnore
    public String getExtractedValue(final String key) {
        return (this.extracted == null) ? null : this.extracted.get(key);
    }

    /**
     * Get an extracted value by its key or return a default value.
     *
     * @param key String with the key of the extracted value.
     * @param defaultValue String with the default value to return if the key does not exist.
     * @return Value with the input key or the input default.
     */
    @JsonIgnore
    public String getExtractedValueOrDefault(final String key, final String defaultValue) {
        return (this.extracted == null) ? defaultValue : this.extracted.getOrDefault(key, defaultValue);
    }

    /** Id of the record. */
    private String id;

    /** Dataset that the record belongs to. */
    private Long dataset;

    /** Version of the dataset. */
    private Long datasetVersion;

    /** Score of the record. */
    private Double score;

    /** Pif system that was matched. */
    private System system;

    /** Map of extracted fields. */
    private Map<String, String> extracted = new HashMap<>();
}