package entities;


    import jakarta.persistence.*;
import lombok.Data;



import jakarta.persistence.*;
import lombok.*;

    @Entity
    @Table(name = "invoice_details")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class InvoiceDetail {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String descripcion;
        private Double monto;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "invoice_id") // nombre de la columna que va en la tabla invoice_details
        private Invoice invoice;

        public boolean getAmount() {
            return this.monto != null && this.monto > 0;
        }

        public Object getPrice() {
            return this.monto;
        }

        public void setMonto(double v) {

        }
    }

