/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.gestioneau.client.TabView;

public enum InventoryStatus {
    INSTOCK("In Stock"),
    OUTOFSTOCK("Out of Stock"),
    LOWSTOCK("Low Stock");

    private String text;

    InventoryStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
