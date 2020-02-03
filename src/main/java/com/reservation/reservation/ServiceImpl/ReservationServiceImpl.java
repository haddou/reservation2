package com.reservation.reservation.ServiceImpl;

import com.reservation.reservation.model.Reservation;
import com.reservation.reservation.repository.JoueurRepository;
import com.reservation.reservation.repository.ReservationRepository;
import com.reservation.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import com.reservation.reservation.Exception.ReservationInvalideException;


@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private JoueurRepository joueurRepository;



    @Override
    public Reservation savereservation(Reservation reservation) throws ReservationInvalideException {

        List<Predicate<Reservation>> reservationvalide = new ArrayList<Predicate<Reservation>>();
        System.out.println();
        Predicate<Reservation> joueurinscrit = r -> joueurRepository.findAll().containsAll(r.getListeDesJoueurs());
        Predicate<Reservation> numbrejoueurmin2 = r -> r.getListeDesJoueurs().size()>= 2 ;
        Predicate<Reservation> numbrejoueurmax6 = r -> r.getListeDesJoueurs().size()<= 8 ;
        Predicate<Reservation> terraindispo = r -> r.getTerrain().isDisponible() ;
        Predicate<Reservation> creneau = r -> r.getCreneau()>=1 ;

        reservationvalide.addAll(Arrays.asList(joueurinscrit,numbrejoueurmin2,numbrejoueurmax6,terraindispo,creneau));
        boolean reservatinetat = reservationvalide.stream().reduce(x->true, Predicate::and).test(reservation);
        System.err.println(reservatinetat);

        if (reservatinetat) {
            double prix = 0.0;
            if (reservation.getCreneau() == 1) {
                prix = 8.0;
            } else if (reservation.getCreneau() > 1) {
                int i=1;
                double prixparheure=8.00;
                prix=8.0;
                while (i < reservation.getCreneau()) {
                    prixparheure= (double) (prixparheure -(prixparheure * (0.05)));
                    System.out.println(prixparheure);
                    prix = Double.sum(prix,prixparheure);
                    i++;
                }

            }

            reservation.setPrix(prix);
            reservationRepository.save(reservation);
            return reservation;
        }
        else {

            throw new ReservationInvalideException("les informations saisies sont fausses : ");

        }


    }

    @Override
    public List<Reservation> getlistreservation() {
        return reservationRepository.findAll();
    }

}