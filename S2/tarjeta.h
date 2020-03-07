#ifndef TARJETA_H
#define TARJETA_H

#include "componenteequipo.h"

class Tarjeta : public ComponenteEquipo
{
public:
    Tarjeta(int p, string n);
    void aceptar(VisitanteEquipo * v);
};

#endif // TARJETA_H
