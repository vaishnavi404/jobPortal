import express from  'express';
import {createReadStream, statSync} from 'fs';
import { dirname } from 'path';
import { fileURLToPath } from 'url';
const __fileName= fileURLToPath(import.meta.url);
const __dirname = dirname(__fileName);
console.log("__dirname",__dirname);
const app = express();
app.get("/",(req,res)=>{
    res.send("Hello world");

});
app.get("/video",(req,res)=>
{
   const filePath= `${__dirname}/file_example_MP4_480_1_5MG.mp4`;
  const stat = statSync(filePath);
const fileSize = stat.size;

   const range = req.headers.range;
if(!range){
    res.status(400).send("Reqiure Range Header")
}


const chunksize=10**6;

const start = Number(range.replace(/\S/g,""
));
const end = Math.min(start+chunksize,fileSize);
const contentLength=end-start+1;
   const fileStream=createReadStream(filePath,{
start,
    end ,
});

fileStream.pipe(res);

const header={
    "Const-Range":`bytes ${start}-${end}/${fileSize}`,
    "Accept-Ranges":"bytes",
    "Content-Length":contentLength,
    "Content-Type":"video/mp4",
}
res.writeHead(206,header)

});
app.listen(3000,()=>{
    console.log("server is running on part 3000")
})
