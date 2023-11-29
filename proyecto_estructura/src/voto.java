import java.util.ArrayList;

public class voto {
    public static ArrayList<Integer> votos(map_candidato m_c,map_votante m_v){
        ArrayList<Integer> candidatos = new ArrayList<>();
        ArrayList<Integer> votos = new ArrayList<>();
        ArrayList<Integer> numero_votos = new ArrayList<>();
        int aux=-1;
        for(Integer i:m_c.candidato.keySet()){
            candidatos.add(i);
        }
        for(Integer j:m_v.votante.keySet()){
            int k= m_v.votante.get(j).getCi_candidato();
            votos.add(k);
        }
        for(int o = 0; o <candidatos.size(); o++){
            numero_votos.add(0);
        }
        for (Integer i : candidatos) {
            aux++;
            for (Integer j : votos) {
                if (j.equals(i)) {
                    int newValue = numero_votos.get(aux) + 1;
                    numero_votos.set(aux, newValue);
                }
            }
        }
        return numero_votos;
    }
    public static ArrayList<String> candidatos(map_candidato m_c){
        ArrayList<String> candidatos = new ArrayList<>();
        for(Integer i:m_c.candidato.keySet()){
            candidatos.add(m_c.candidato.get(i).getOrganizacion()+" "+m_c.candidato.get(i).getNombre()+" "+m_c.candidato.get(i).getApellido_p()+" "+m_c.candidato.get(i).getApellido_m());
        }
        return candidatos;
    }
    public static ArrayList<String> votantes(map_votante m_v){
        ArrayList<String> votantes = new ArrayList<>();
        for(Integer i:m_v.getVotante().keySet()){
            votantes.add(i+" "+m_v.votante.get(i).getNombre()+" "+m_v.votante.get(i).getApellido_p()+" "+m_v.votante.get(i).getApellido_m());
        }
        return votantes;
    }
}
