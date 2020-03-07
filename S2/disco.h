#ifndef DISCO_H
#define DISCO_H

#include "componenteequipo.h"

class Disco : public ComponenteEquipo {
public:
    Disco(int p, string n);
    void aceptar (VisitanteEquipo * v);
};

#endif // DISCO_H
