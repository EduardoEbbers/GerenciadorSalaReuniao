package com.gerencia.reuniao.ProjetoGerenciaReuniao.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "meetingroom")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "startHour", nullable = false)
    private String startHour;

    @Column(name = "endHour", nullable = false)
    private String endHour;

    @Override
    public String toString() {
        return "Rooom [id="+id+",name="+name+",date="+date+",startHour="+startHour+",endHour="+endHour+"]";
    }
}
