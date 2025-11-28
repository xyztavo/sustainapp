package br.com.etecia.sustainapp.data;

/**
 * Modelo de dados para um item inteligente (solução inteligente).
 */
public class SmartItem {
    private String name;
    private String category;
    private String description;

    public SmartItem(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}