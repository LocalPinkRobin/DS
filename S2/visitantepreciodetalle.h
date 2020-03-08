#ifndef VISITANTEPRECIODETALLE_H
#define VISITANTEPRECIODETALLE_H

#include "visitanteequipo.h"
#include <string>

using namespace std;

class VisitantePrecioDetalle : public VisitanteEquipo
{
public:
    VisitantePrecioDetalle();
    void VisitarDisco(Disco * d);
    void VisitarTarjeta (Tarjeta * t);
    void VisitarBus (Bus * B);
    string getPrecio();

private:
    string disco;
    string tarjeta;
    string bus;
};

#endif // VISITANTEPRECIODETALLE_H
