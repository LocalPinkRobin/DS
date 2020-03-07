#ifndef VISITANTEEQUIPO_H
#define VISITANTEEQUIPO_H

#include "disco.h"
#include "tarjeta.h"
#include "bus.h"

class VisitanteEquipo
{
public:
    VisitanteEquipo();
    virtual void VisitarDisco(Disco * d) = 0;
    virtual void VisitarTarjeta (Tarjeta * t) = 0;
    virtual void VisitarBus (Bus * b) = 0;
};

#endif // VISITANTEEQUIPO_H
