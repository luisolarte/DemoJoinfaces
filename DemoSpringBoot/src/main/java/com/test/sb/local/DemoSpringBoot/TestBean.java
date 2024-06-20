package com.test.sb.local.DemoSpringBoot;




import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import org.primefaces.event.ItemSelectEvent;
import org.springframework.stereotype.Component;
import software.xdev.chartjs.model.charts.PieChart;
import software.xdev.chartjs.model.color.Color;
import software.xdev.chartjs.model.data.PieData;
import software.xdev.chartjs.model.dataset.PieDataset;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * @author Test
 */
@Component("test")
public class TestBean {

    private String pieModel;

    public String getText() {
        return "Hello from Spring: " + LocalDateTime.now();
    }



    public String createPieModel() {


        return new PieChart()
                .setData(new PieData()
                        .addDataset(new PieDataset()
                                .setData(BigDecimal.valueOf(300), BigDecimal.valueOf(50), BigDecimal.valueOf(100))
                                .setLabel("My First Dataset")
                                .addBackgroundColors(new Color(255, 99, 132), new Color(54, 162, 235), new Color(255, 205, 86))
                        )
                        .setLabels("Red", "Blue", "Yellow"))
                .toJson();

    }

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Value: " + event.getData()
                        + ", Item Index: " + event.getItemIndex()
                        + ", DataSet Index:" + event.getDataSetIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}