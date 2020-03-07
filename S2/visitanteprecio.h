#ifndef VISITANTEPRECIO_H
#define VISITANTEPRECIO_H

#include "visitanteequipo.h"

class VisitantePrecio : public VisitanteEquipo
{
public:
    VisitantePrecio();
    void VisitarDisco(Disco * d);
    void VisitarTarjeta (Tarjeta * t);
    void VisitarBus (Bus * B);
    int getPrecio();

private:
    int precio = 0;

};

#endif // VISITANTEPRECIO_H
