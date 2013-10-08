/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adparser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashAttributeSet;
import morfologik.stemming.PolishStemmer;
import morfologik.stemming.WordData;

/**
 * Prepares extracted ad data for classification. Extracts keywords, coints tf/idf, creates similarity vector.
 * @author Karol Abramczyk
 */
public class Preparator {
    private ArrayList<String> stopwords;
    private WordBank wordbank;

    public ArrayList<String> getStopwords() {
        return stopwords;
    }

    public WordBank getWordbank() {
        return wordbank;
    }
    
    public Preparator() {
        stopwords = new ArrayList<>();
        wordbank = new WordBank();
        try {
            loadStopWords("plstopwordsUTF8.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Preparator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Preparator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadStopWords(String path) throws FileNotFoundException, IOException {
        stopwords.clear();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        String line;
        while ((line = reader.readLine()) != null) {
                line.trim();
                stopwords.add(line);
        }
        reader.close();
    }
    
    public void prepareKeywords(Ad ad) {
        //make keywors
        KeyWords stems = getKeywords(ad.getDescription());
        ad.setKeywords(stems);
        //add stems to workbank
        addKeywordsToWordBank(new ArrayList<>(stems.keySet()));
    }
    
    public void prepareSimilarityVector(Ad ad) {
        SimilarityVector v = makeSimilarityVector(ad);
        ad.setSimilarityVector(v);
    }
    
    public KeyWords getKeywords(String text) {
        KeyWords keywords;
        text = removeStopWords(text);
        keywords = doStemming(text);
        return keywords;
    }
    
    public String removeStopWords(String text) {
        String output = text;
        for(String stopword : stopwords) {
            output = output.replaceAll("\\b" + stopword + "\\b", "");
        }
        return output;
    }
    
    public KeyWords doStemming(String text) {
        KeyWords stems = new KeyWords();
        PolishStemmer stemmer = new PolishStemmer();
        StringTokenizer st = new StringTokenizer(text);
        while(st.hasMoreTokens()) {
            List<WordData> list = stemmer.lookup(st.nextToken());
            ArrayList<String> stemList = Utils.getStems(list);
            ArrayList stemListNoDuplicates = Utils.removeDuplicates(stemList);
            
            for(String stem : stemList) {
                if(stems.containsKey(stem)) {
                    KeyWordParams params = new KeyWordParams(stems.get(stem).getTf()+1);
                    stems.put(stem, params);
                } else {
                    KeyWordParams params = new KeyWordParams(1);
                    stems.put(stem, params);
                }
            }
            
            
            //list zawiera duplikaty np. słowo poniedziałek
//            if(list.size() > 0) {
//                WordData lastWord = null;
//                for(WordData word : list) {
//                    if(lastWord!=null && word.getStem().equals(lastWord.getStem())) {
//                        //do nothing
//                    } else {
//                        String stem = word.getStem().toString();
//                        if(stems.containsKey(stem)) {
//                            KeyWordParams params = new KeyWordParams(stems.get(stem).getTf()+1);
//                            stems.put(stem, params);
//                        } else {
//                            KeyWordParams params = new KeyWordParams(1);
//                            stems.put(stem, params);
//                        }
//                        lastWord = word;
//                    }
//                }
//            }
        }
        return stems;
    }
    
    public int addKeywordsToWordBank(ArrayList<String> keywords) {
        int count = 0;
        for(String word : keywords) {
            if(!wordbank.contains(word)) {
                wordbank.addWord(word);
                count++;
            } else {
                wordbank.increaseNumDocs(word);
            }
        }
        return count;
    }
    
    public SimilarityVector makeSimilarityVector(Ad ad) {
        SimilarityVector vector = new SimilarityVector();
        Iterator it = ad.getKeywords().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            String word = (String)pair.getKey();
            int id = wordbank.getID(word);
            double idf = wordbank.size()/wordbank.getNumDocs(word);
            int tf = ((KeyWordParams)pair.getValue()).getTf();
            double tfidf = tf*idf;
            vector.put(id,tfidf);
        }
        //sort vector ?
        
        return vector;
    }
    
    public String stopWordsToString() {
        String s = "";
        for(String word : stopwords) {
            s += word + " ";
        }
        s.trim();
        return s;
    }
    
    
}
