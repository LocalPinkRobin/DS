#ifndef BUS_H
#define BUS_H

#include "componenteequipo.h"

class Bus : public ComponenteEquipo
{
public:
    Bus(int p, string n);
    void aceptar (VisitanteEquipo * v);
};

#endif // BUS_H
