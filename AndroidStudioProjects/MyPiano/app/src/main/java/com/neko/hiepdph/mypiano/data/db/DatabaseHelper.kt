package com.neko.hiepdph.mypiano.data.db

import android.content.Context


class DatabaseHelper
    (val context: Context) {

    private fun getCSVFile(): String {
        return "BloodPressure_CSV.csv"
    }
//
//    fun exportDatabaseToCSVFile(list: List<HistoryModel>) {
//        Toast.makeText(context, context.getText(R.string.generating_csv), Toast.LENGTH_LONG)
//            .show()
//        val csvFile = FileUtils.generateFile(context, getCSVFile())
//        if (csvFile != null) {
//            Log.d("TAG", "exportDatabaseToCSVFile: " + csvFile.absolutePath)
//            exportTrackerToCSVFile(list, csvFile)
//            val intent = FileUtils.shareFileIntent(context, csvFile)
//            context.startActivity(Intent.createChooser(intent, "Share file"))
//            Toast.makeText(context, context.getText(R.string.gen_csv_success), Toast.LENGTH_LONG)
//                .show()
//        } else {
//            Toast.makeText(context, context.getText(R.string.gen_csv_failed), Toast.LENGTH_LONG)
//                .show()
//        }
//
//
//    }

//    private fun exportTrackerToCSVFile(list: List<HistoryModel>, file: File) {
//        csvWriter().open(file, append = false) {
//            writeRow(
//                listOf(
//                    "[Id]",
//                    "[Systolic(mmHg)]",
//                    "[Diastolic(mmHg)]",
//                    "[Pulse(mmHg)]",
//                    "[Time]",
//                    "[Date]",
//                    "[Notes]"
//                )
//            )
//            list.forEach { item ->
//                writeRow(
//                    listOf(
//                        item.id,
//                        item.systolic,
//                        item.diastolic,
//                        item.pulse,
//                        item.time,
//                        item.date,
//                        item.notes
//                    )
//                )
//            }

//
//        }
//    }


}