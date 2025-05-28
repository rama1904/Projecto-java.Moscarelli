package entities;



import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(nullable= false)
    private String apellido;
    @Column(nullable= false)
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Invoice> invoices;

    public boolean getNombre() {
        return this.nombre != null && !this.nombre.isEmpty();
    }

    public ThreadLocal<Object> getInvoices() {
        return null;
    }
}

