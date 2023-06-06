1) select * from cargo;
2) select nome, qt_vereadores from cidade
   order by nome;
3) select nome, qt_vereadores from cidade where qt_vereadores = 9;
4) select count(*) as total_cidades
   from cidade
   where qt_vereadores > 9;
5) select max(qt_vereadores) from cidade;
6) select nome from cidade where qt_vereadores = (select max(qt_vereadores)from cidade); //sub select
7) select nome, cargo from candidato where cargo = 1
   order by nome;
8) select nome from candidato where nome like '%MARIA%' and cargo = 2
   order by nome; //não puxou nada
9) select nome, cargo from candidato where nome like 'Y%' and cargo = 2
   order by nome;
10) select can.nome, cid.nome, can.cargo 
    from candidato can
    inner join cidade cid on can.cidade = cid.id
    and can.cargo = 1
    order by cid.nome, can.nome;
11) select can.nome from candidato can
    where can.cargo = 1
    and can.cidade = (select cid.id from cidade cid where cid.nome = 'TUBARÃO')
    order by can.nome;
12) select can.nome 
    from candidato can
    where can.cargo = 1 and can.cidade = (select cidade.id from cidade order by qt_eleitores desc limit 1);
13) select cidade.qt_vereadores 
    from cidade
    where cidade.nome like 'TUBARÃO';

select count(*)
from candidato c
inner join cidade on cidade.id = c.cidade and cidade.nome = 'TUBARÃO'
where c.cargo = 2;

ouu

select count(*)
from candidato c
inner join cidade on cidade.id = c.cidade and cidade.nome = 'TUBARÃO'
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador';


14) select cidade.nome, cidade.qt_vereadores 
    from cidade
    order by cidade.nome;


select cidade.nome, count(cand.*)
from cidade 
inner join candidato cand on cand.cidade = cidade.id
inner join cargo on cargo.id = candidato.cargo and cargo.nome = "Vereador"
group by cidade.nome
order by cidade.nome;


15) select vi.brancos, vi.nulos 
    from voto_invalido vi 
    where vi.cidade = (select cidade.id from cidade where cidade.nome like 'TUBARÃO')


select cargo.nome, vi.brancos, vi.nulos
from voto_invalido vi
inner join cidade on vi.cidade = cidade.id and cidade.nome = 'TUBARÃO'
inner join cargo on cargo.id = vi.cargo


16) select vi.brancos + vi.nulos as total
    from voto_invalido vi
    where vi.cargo = 1 and vi.cidade = (select cidade.id from cidade where cidade.nome like 'TUBARÃO');


select vi.brancos + vi.nulos as invalidos
from voto invalido vi
inner join cidade on vi.cidade = cidade.id and cidade.nome = 'TUBARÃO'
inner join cargo on cargo.id = vi.cargo and cargo.nome = 'Prefeito'



17) select voto.voto  
    from voto
    where voto.candidato = (select candidato.id from candidato 
						where candidato.cargo = 1 
						and candidato.cidade = (select cidade.id from cidade
						where cidade.nome like 'TUBARÃO'))
    order by max(voto.voto);


select candidato.nome, voto.voto  
from voto
inner join candidato on candidato.id = voto.candidato
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
order by voto.voto desc;


18) select voto.voto 
    from voto
    where voto.candidato in (select candidato.id from candidato 
						where candidato.cargo = 2 
						and candidato.cidade = (select cidade.id from cidade
						where cidade.nome like 'TUBARÃO'))
    order by voto.voto desc;

19) select cidade.nome, candidato.nome, max(voto.voto) as maior_voto
    from voto 
    inner join candidato on voto.candidato = candidato.id
    inner join cidade on candidato.cidade = cidade.id
    where candidato.cargo = 2
    group by candidato.nome, cidade.nome;


select cidade.nome, candidato.nome, max(voto.voto) as maior_voto
    from voto 
    inner join candidato on voto.candidato = candidato.id
    inner join cidade on candidato.cidade = cidade.id
    inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
    group by candidato.nome, cidade.nome;


20) select partido.sigla, sum(voto.voto) as votos
from voto
inner join candidato on candidato.id = voto.candidato 
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
inner join partido on partido.id = candidato.partido 
group by partido.sigla
order by votos desc;
