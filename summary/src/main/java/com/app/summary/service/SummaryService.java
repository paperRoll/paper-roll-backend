package com.app.summary.service;

import com.app.summary.client.TSClient;
import com.app.summary.domain.SummaryRecord;
import com.app.summary.domain.dto.SummaryRecordDTO;
import com.app.summary.domain.req.SummaryFetchTSRequest;
import com.app.summary.domain.res.SummaryFetchTSResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SummaryService {

    private TSClient tsClient;

    @Autowired
    public void setTsClient(TSClient tsClient) {
        this.tsClient = tsClient;
    }

    public List<SummaryRecord> getSummaryRecords(int employeeId) {

        SummaryFetchTSRequest summaryFetchTSRequest = SummaryFetchTSRequest.builder()
                .employeeId(employeeId)
                .build();

        SummaryFetchTSResponse summaryFetchTSResponse = tsClient.getSummaryRecords(summaryFetchTSRequest);

        List<SummaryRecord> summaryRecords = new ArrayList<>();
        List<SummaryRecordDTO> summaryRecordDTOs = summaryFetchTSResponse.getSummaryRecordDTOs();

        if(summaryRecordDTOs == null) {
            return null;
        }

        for(SummaryRecordDTO summaryRecordDTO : summaryRecordDTOs) {
            summaryRecords.add(getSummaryRecord(summaryRecordDTO));
        }

        return summaryRecords;
    }

    private SummaryRecord getSummaryRecord(SummaryRecordDTO summaryRecordDTO) {
        SummaryRecord summaryRecord = new SummaryRecord();

        summaryRecord.setWeekEnding(summaryRecordDTO.getWeekEnding());
        summaryRecord.setTotalBillingHours(summaryRecordDTO.getTotalBillingHours());
        summaryRecord.setTotalCompensatedHours(summaryRecordDTO.getTotalCompensatedHours());
        summaryRecord.setSubmissionStatus(summaryRecordDTO.getSubmissionStatus());
        summaryRecord.setApprovalStatus(summaryRecordDTO.getApprovalStatus());
        summaryRecord.setComment(summaryRecordDTO.getComment());

        return summaryRecord;
    }
}
