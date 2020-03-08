#ifndef EQUIPO_H
#define EQUIPO_H

#include <vector>

#include "visitanteequipo.h"

class Equipo
{
public:
    Equipo(Disco *d, Tarjeta *t, Bus *b);
    ~Equipo();
    void aceptar(VisitanteEquipo *v);
private:
    Disco* disco;
    Tarjeta* tarjeta;
    Bus* bus;
};

#endif // EQUIPO_H
